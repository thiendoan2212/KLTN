import {Component, HostListener, OnInit} from '@angular/core';
import {PostDTO} from '../model/postDTO';
import {AngularEditorConfig} from '@kolkov/angular-editor';
import {AccomodationDTO} from '../model/accomodationDTO';
import {GeocodingApiServiceService} from '../service/geocoding-api-service.service';
import {PostService} from '../service/post.service';
import {FileUploader} from 'ng2-file-upload';
import {ImageService} from '../service/image.service';
import {ImageDTO} from '../model/ImageDTO';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss']
})
export class CreatePostComponent implements OnInit {
  postDTO: PostDTO = new PostDTO();
  imageDTO: ImageDTO[] = new Array();
  errorMessage: '';
  accomodationDTO: AccomodationDTO = new AccomodationDTO();
  htmlContent = '';
  config: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    height: '15rem',
    minHeight: '5rem',
    placeholder: 'Enter text here...',
    translate: 'no',
    customClasses: [
      {
        name: 'quote',
        class: 'quote',
      },
      {
        name: 'redText',
        class: 'redText'
      },
      {
        name: 'titleText',
        class: 'titleText',
        tag: 'h1',
      },
    ]
  };

  zoom = 13;
  lat = 10.776111;
  lng = 106.695833;

  public innerWidth: any;

  public uploader: FileUploader = new FileUploader({
    isHTML5: true
  });

  showError = false;
  showRequired = false;

  constructor(private geocodingApiService: GeocodingApiServiceService,
              private postService: PostService,
              private imageService: ImageService) {
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
    this.setValue();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
  }

  onSubmit() {
    if (this.uploader.queue.length !== 0) {
      console.log('Accepted');
    }
  }

  setValue() {
    this.postDTO.accomodationDTO = this.accomodationDTO;
    this.postDTO.accomodationDTO.waterPrice = this.postDTO.accomodationDTO.electricPrice = 0;
  }

  mapClicked($event: any) {
    this.postDTO.accomodationDTO.xCoordinate = $event.coords.lat;
    this.postDTO.accomodationDTO.yCoordinate = $event.coords.lng;
  }

  markerDragEnd($event: any) {
    this.postDTO.accomodationDTO.xCoordinate = $event.coords.lat;
    this.postDTO.accomodationDTO.yCoordinate = $event.coords.lng;
  }

  updateLatLngFromAddress() {
    this.geocodingApiService
      .findFromAddress(this.postDTO.accomodationDTO.address).subscribe(response => {
      if (response.status === 'OK') {
        // this.lat = response.results[0].geometry.location.lat;
        // this.lng = response.results[0].geometry.location.lng;
        this.postDTO.accomodationDTO.xCoordinate = response.results[0].geometry.location.lat;
        this.postDTO.accomodationDTO.yCoordinate = response.results[0].geometry.location.lng;
        console.log('GEO ' + this.postDTO.accomodationDTO.xCoordinate);
        console.log('GEO ' + this.postDTO.accomodationDTO.yCoordinate);
      } else if (response.status === 'ZERO_RESULTS') {
        console.log('geocodingAPIService', 'ZERO_RESULTS', response.status);
      } else {
        console.log('geocodingAPIService', 'Other error', response.status);
      }
    });
  }

  createPost() {
    this.postService.createPost(this.postDTO).subscribe(
      data => {
        this.postDTO = data;
        console.log(this.postDTO);
      },
      error => {
        this.errorMessage = error.error.message;
        console.log(this.errorMessage);
      }
    );
    this.addImageForPost(this.postDTO);
  }

  addImageForPost(postDTO: PostDTO) {
    if (postDTO.id) {
      for (const uploader of this.uploader.queue) {
        const formData = new FormData();
        const fileItem = uploader._file;
        formData.append('file', fileItem);
        this.imageService.addImageForPost(postDTO.id, formData).subscribe(
          data => {
            this.imageDTO = data;
            console.log(this.imageDTO);
          },
          error => {
            this.errorMessage = error.error.message;
            console.log(this.errorMessage);
          }
        );
      }
    } else {
      this.showError = true;
    }
  }

  ClickedOut(event) {
    if (event.target.className === 'modal fade show') {
      this.showError = false;
      this.showRequired = false;
    }
  }
}
