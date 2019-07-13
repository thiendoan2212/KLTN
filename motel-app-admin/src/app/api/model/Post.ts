import {Image} from './Image';
import {Accomodation} from './Accomodation';

export class Post {
  id: number;
  title: string;
  content: string;
  approved: boolean;
  notApproved: boolean;
  createAt: string;
  lastUpdate: string;
  delete: boolean;
  username: string;
  accomodationDTO: Accomodation;
  imageStrings: string[];
}
