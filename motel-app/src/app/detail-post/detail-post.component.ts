import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';
import {ToiletName} from '../model/ToiletName';
import {StoragepostService} from '../service/storagepost.service';

@Component({
  selector: 'app-detail-post',
  templateUrl: './detail-post.component.html',
  styleUrls: ['./detail-post.component.scss']
})
export class DetailPostComponent implements OnInit {
  postDTO: PostDTO;
  errorMessage: '';
  ToiletName = ToiletName;
  util = ' ';
  zoom = 15;

  constructor(private route: ActivatedRoute,
              private postService: PostService,
              private storagePostService: StoragepostService) {
  }

  ngOnInit() {
    this.getPostById();
  }

  getPostById() {
    this.postDTO = this.storagePostService.getStoragePostDTO();
    console.log(this.postDTO);
    if (this.postDTO.accomodationDTO.parking) {
      this.util += 'Chỗ để xe';
    }
    if (this.postDTO.accomodationDTO.internet) {
      this.util += ', Internet';
    }
    if (this.postDTO.accomodationDTO.airConditioner) {
      this.util += ', Điều hòa';
    }
    if (this.postDTO.accomodationDTO.cableTV) {
      this.util += ', Truyền hình cáp';
    }
    if (this.postDTO.accomodationDTO.tv) {
      this.util += ', Tivi';
    }
    if (this.postDTO.accomodationDTO.heater) {
      this.util += ', Máy nước nóng';
    }
    if (this.util.startsWith(' , ')) {
      this.util = this.util.substring(2);
    }
    // const id = +this.route.snapshot.paramMap.get('id');
    // this.postService.getPostById(id).subscribe(
    //   data => {
    //     this.postDTO = data;
    //     if (this.postDTO.accomodationDTO.parking) {
    //       this.util += 'Chỗ để xe';
    //     }
    //     if (this.postDTO.accomodationDTO.internet) {
    //       this.util += ', Internet';
    //     }
    //     if (this.postDTO.accomodationDTO.airConditioner) {
    //       this.util += ', Điều hòa';
    //     }
    //     if (this.postDTO.accomodationDTO.cableTV) {
    //       this.util += ', Truyền hình cáp';
    //     }
    //     if (this.postDTO.accomodationDTO.tv) {
    //       this.util += ', Tivi';
    //     }
    //     if (this.postDTO.accomodationDTO.heater) {
    //       this.util += ', Máy nước nóng';
    //     }
    //
    //     if (this.util.startsWith(' , ')) {
    //       this.util = this.util.substring(2);
    //     }
    //   },
    //   error => {
    //     this.errorMessage = error.error.message;
    //     console.log(this.errorMessage);
    //   }
    // );
  }
}
