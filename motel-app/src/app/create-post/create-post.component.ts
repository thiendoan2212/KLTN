import {Component, HostListener, OnInit} from '@angular/core';
import {PostDTO} from '../model/postDTO';
import {AngularEditorConfig} from '@kolkov/angular-editor';
import {CommentDTO} from '../model/commentDTO';
import {AccomodationDTO} from '../model/accomodationDTO';
import {GeocodingApiServiceService} from '../service/geocoding-api-service.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss']
})
export class CreatePostComponent implements OnInit {
  postDTO: PostDTO = new PostDTO();
  accomodationDTO: AccomodationDTO = new AccomodationDTO();
  districtDefault: number;
  urls = new Array<string>();
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

  submitted = false;

  constructor(private geocodingApiService: GeocodingApiServiceService) {
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
    this.setValue();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
  }

  fileEvent(event: any) {
    this.urls = [];
    const files = event.target.files;
    if (files) {
      for (const file of files) {
        const reader = new FileReader();
        reader.onload = (e: any) => {
          this.urls.push(e.target.result);
        };
        reader.readAsDataURL(file);
      }
    }
  }

  onSubmit() {
    this.submitted = true;
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
}
