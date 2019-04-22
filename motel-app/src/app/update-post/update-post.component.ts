import {Component, HostListener, OnInit} from '@angular/core';
import {PostDTO} from '../model/postDTO';
import {AccomodationDTO} from '../model/accomodationDTO';
import {AngularEditorConfig} from '@kolkov/angular-editor';
import {FileUploader} from 'ng2-file-upload';
import {GeocodingApiServiceService} from '../service/geocoding-api-service.service';
import {PostService} from '../service/post.service';
import {ImageService} from '../service/image.service';
import {Router} from '@angular/router';
import {Image} from '../model/image';
import {ImageHandlerService} from '../service/image-handler.service';
import {ImageDTO} from '../model/ImageDTO';

@Component({
  selector: 'app-update-post',
  templateUrl: './update-post.component.html',
  styleUrls: ['./update-post.component.scss']
})
export class UpdatePostComponent implements OnInit {
  postDTO: PostDTO = new PostDTO();
  imageDTO: ImageDTO[] = new Array();
  images: Image[] = new Array();
  errorMessage: '';
  accomodationDTO: AccomodationDTO = new AccomodationDTO();
  config: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    height: '15rem',
    minHeight: '5rem',
    placeholder: 'Nhập nội dung ở đây...',
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

  zoom = 15;
  lat = 10.776111;
  lng = 106.695833;

  public innerWidth: any;

  // uploader: FileUploader = new FileUploader({url: ''});
  public uploader: FileUploader = new FileUploader({
    isHTML5: true
  });

  showError = false;
  showRequired = false;
  showNoti = false;
  disableSubmit = false;
  showLoadding = false;

  status: number;
  motel: number;
  parking: number;
  internet: number;
  airConditioner: number;
  cableTV: number;
  tv: number;
  heater: number;

  constructor(private geocodingApiService: GeocodingApiServiceService,
              private postService: PostService,
              private imageService: ImageService,
              private imageHandler: ImageHandlerService,
              private router: Router) {
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
      this.postDTO.username = 'admin';
      this.updatePost();
    }
  }

  setValue() {
    // // this.postDTO = this.storagePostService.getStoragePostDTO();
    // this.getImageByteByIdPost(this.postDTO.id);
    // if (this.postDTO.accomodationDTO.status) {
    //   this.status = 1;
    // } else {
    //   this.status = 0;
    // }
    // if (this.postDTO.accomodationDTO.motel) {
    //   this.motel = 1;
    // } else {
    //   this.motel = 2;
    // }
    // if (this.postDTO.accomodationDTO.parking) {
    //   this.parking = 1;
    // } else {
    //   this.parking = 0;
    // }
    // if (this.postDTO.accomodationDTO.internet) {
    //   this.internet = 1;
    // } else {
    //   this.internet = 0;
    // }
    // if (this.postDTO.accomodationDTO.airConditioner) {
    //   this.airConditioner = 1;
    // } else {
    //   this.airConditioner = 0;
    // }
    // if (this.postDTO.accomodationDTO.cableTV) {
    //   this.cableTV = 1;
    // } else {
    //   this.cableTV = 0;
    // }
    // if (this.postDTO.accomodationDTO.tv) {
    //   this.tv = 1;
    // } else {
    //   this.tv = 0;
    // }
    // if (this.postDTO.accomodationDTO.heater) {
    //   this.heater = 1;
    // } else {
    //   this.heater = 0;
    // }
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

  getImageByteByIdPost(id: number) {
    this.imageService.getImageByteByIdPost(id).subscribe(
      res => {
        this.images = res;
        const files: Array<File> = [];
        for (const image of this.images) {
          image.uri = 'data:image/png;base64,' + image.uri;
          const dataBlob = this.imageHandler.getBlob(image.uri, image.fileType);
          const file = new File([dataBlob], image.fileName, {type: image.fileType});
          console.log(file);
          files.push(file);
        }
        this.uploader.addToQueue(files);
      },
      error => {
        this.errorMessage = error.error.message;
        console.log(this.errorMessage);
      }
    );
  }

  updatePost() {
    this.disableSubmit = true;
    this.showLoadding = true;
    if (this.status === 1) {
      this.postDTO.accomodationDTO.status = true;
    } else {
      this.postDTO.accomodationDTO.status = false;
    }
    if (this.motel === 1) {
      this.postDTO.accomodationDTO.motel = true;
    } else {
      this.postDTO.accomodationDTO.motel = false;
    }
    if (this.parking === 1) {
      this.postDTO.accomodationDTO.parking = true;
    } else {
      this.postDTO.accomodationDTO.parking = false;
    }
    if (this.internet === 1) {
      this.postDTO.accomodationDTO.internet = true;
    } else {
      this.postDTO.accomodationDTO.internet = false;
    }
    if (this.airConditioner === 1) {
      this.postDTO.accomodationDTO.airConditioner = true;
    } else {
      this.postDTO.accomodationDTO.airConditioner = false;
    }
    if (this.cableTV === 1) {
      this.postDTO.accomodationDTO.cableTV = true;
    } else {
      this.postDTO.accomodationDTO.cableTV = false;
    }
    if (this.tv === 1) {
      this.postDTO.accomodationDTO.tv = true;
    } else {
      this.postDTO.accomodationDTO.tv = false;
    }
    if (this.heater === 1) {
      this.postDTO.accomodationDTO.heater = true;
    } else {
      this.postDTO.accomodationDTO.heater = false;
    }
    this.postService.updatePost(this.postDTO.id, this.postDTO).subscribe(
      data => {
        this.addImageForPost(this.postDTO.id);
      },
      error => {
        this.errorMessage = error.error.message;
        console.log(this.errorMessage);
      }
    );
  }

  addImageForPost(id: number) {
    if (id != null) {
      this.imageService.deleteAllImage(id);
      for (const uploader of this.uploader.queue) {
        const formData = new FormData();
        const fileItem = uploader._file;
        formData.append('file', fileItem);
        this.imageService.addImageForPost(id, formData).subscribe(
          data => {
            this.imageDTO = data;
            if (this.imageDTO) {
              this.showNoti = true;
              this.showLoadding = false;
              setTimeout(() => {
                this.router.navigate(['/trang-chu']);
              }, 5000);
            }
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
