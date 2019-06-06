import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {PaginationDTO} from '../model/paginationDTO';
import {NotificationDTO} from '../model/notificationDTO';
import {NotificationService} from '../service/notification.service';
import * as moment from 'moment';
import {CriteriaService} from '../service/criteria.service';
import {CriteriaDTO} from '../model/criteriaDTO';
import {PostDTO} from '../model/postDTO';
import {Router} from '@angular/router';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class NotificationComponent implements OnInit {
  panelOpenState = false;
  paginationDTO = new PaginationDTO();
  notificationDTOs: NotificationDTO[];
  totalElementNoti: number;
  criteriaDTOS: CriteriaDTO[];
  totalElementCriteria: number;
  subNotificationDTOS: NotificationDTO[];
  totalElementSubNoti: number;
  pageNoti = 0;
  pageCriteria = 0;
  pageSubNoti = 0;
  showLoadding = false;
  a: boolean;

  constructor(private notificationService: NotificationService,
              private criteriaService: CriteriaService,
              private sanitizer: DomSanitizer,
              private router: Router) {
  }

  ngOnInit() {
    this.getNotificationByEmail();
    this.getCriteria();
  }

  getNotificationByEmail() {
    this.notificationService.getNotificationByEmail(this.pageNoti, true).subscribe(
      data => {
        this.paginationDTO.content = data;
        this.notificationDTOs = this.paginationDTO.content.content;
        this.totalElementNoti = this.paginationDTO.content.totalElements;
        for (const notificationDTO of this.notificationDTOs) {
          const a = new Date();
          const date: number = moment(notificationDTO.createAt, 'YYYY-MM-DDTHH:mm:ss').valueOf();
          const b = (a.getTime() - date) / 1000;
          if (b < 3600) {
            notificationDTO.createAt = (Math.floor(b / 60)).toString();
            notificationDTO.unit = 'phút';
          } else if (b >= 3600 && b < 86400) {
            notificationDTO.createAt = (Math.floor(b / 3600)).toString();
            notificationDTO.unit = 'giờ';
          } else if (b >= 86400 && b < 2628000) {
            notificationDTO.createAt = (Math.floor(b / 86400)).toString();
            notificationDTO.unit = 'ngày';
          } else if (b >= 2628000 && b < 31536000) {
            notificationDTO.createAt = (Math.floor(b / 2628000)).toString();
            notificationDTO.unit = 'tháng';
          } else {
            notificationDTO.createAt = (Math.floor(b / 31536000)).toString();
            notificationDTO.unit = 'năm';
          }
        }
      }, error => {
        console.log(error.error.message);
      }
    );
  }

  seen(notificationDTO: NotificationDTO) {
    if (!notificationDTO.seen) {
      this.notificationService.seenNotification(notificationDTO.id).subscribe(
        data => {
          this.getNotificationByEmail();
        },
        error => {
          console.log(error.error.message);
        }
      );
    }
  }

  navigateToDetail(postDTO: PostDTO) {
    this.router.navigate(['/post'], {queryParams: {id: postDTO.id}, skipLocationChange: false});
  }

  getCriteria() {
    this.criteriaService.getCriteria(this.pageCriteria, true).subscribe(
      data => {
        this.paginationDTO.content = data;
        this.criteriaDTOS = this.paginationDTO.content.content;
        this.totalElementCriteria = this.paginationDTO.content.totalElements;
      },
      error => {
      }
    );
  }

  getNotificationByEmailAndCriteria(idCriteria: number) {
    this.totalElementSubNoti = -1;
    this.paginationDTO = new PaginationDTO();
    this.showLoadding = true;
    this.notificationService.getNotificationByEmailAndCriteria(idCriteria, this.pageSubNoti).subscribe(
      data => {
        this.paginationDTO.content = data;
        this.subNotificationDTOS = this.paginationDTO.content.content;
        this.totalElementSubNoti = this.paginationDTO.content.totalElements;
        for (const notificationDTO of this.subNotificationDTOS) {
          const a = new Date();
          const date: number = moment(notificationDTO.createAt, 'YYYY-MM-DDTHH:mm:ss').valueOf();
          const b = (a.getTime() - date) / 1000;
          if (b < 3600) {
            notificationDTO.createAt = (Math.floor(b / 60)).toString();
            notificationDTO.unit = 'phút';
          } else if (b >= 3600 && b < 86400) {
            notificationDTO.createAt = (Math.floor(b / 3600)).toString();
            notificationDTO.unit = 'giờ';
          } else if (b >= 86400 && b < 2628000) {
            notificationDTO.createAt = (Math.floor(b / 86400)).toString();
            notificationDTO.unit = 'ngày';
          } else if (b >= 2628000 && b < 31536000) {
            notificationDTO.createAt = (Math.floor(b / 2628000)).toString();
            notificationDTO.unit = 'tháng';
          } else {
            notificationDTO.createAt = (Math.floor(b / 31536000)).toString();
            notificationDTO.unit = 'năm';
          }
        }
        this.showLoadding = false;
      },
      error => {
      }
    );
  }
}
