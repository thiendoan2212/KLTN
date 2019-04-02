import {AccomodationDTO} from './accomodationDTO';
import {CommentDTO} from './commentDTO';
import {ImageResponse} from './imageResponse'

export class PostDTO {
  id: number;
  title: string;
  content: string;
  approved: boolean;
  notApproved: boolean;
  createAt: string;
  lastUpdate: string;
  delete: boolean;
  username: string;
  accomodationDTO: AccomodationDTO;
  commentDTOS: CommentDTO[];
  imageStrings: ImageResponse[];
}
