import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-detail-post',
  templateUrl: './detail-post.component.html',
  styleUrls: ['./detail-post.component.scss']
})
export class DetailPostComponent implements OnInit {
  motel = 0;
  elements: any = [
    {id: 1, first: 'Mark', last: 'Otto', handle: '@mdo'},
    {id: 2, first: 'Jacob', last: 'Thornton', handle: '@fat'},
    {id: 3, first: 'Larry', last: 'the Bird', handle: '@twitter'},
  ];

  lat = 51.678418;
  lng = 7.809007;

  headElements = ['ID', 'First', 'Last', 'Handle'];

  constructor() {
  }

  ngOnInit() {
  }

}
