import {PostDTO} from './postDTO';

export class AccomodationDTO {
  id: number;
  acreage: number;
  address: string;
  electricPrice: number;
  waterPrice: number;
  internet: boolean;
  toilet: boolean;
  price: number;
  mezzanine: boolean;
  upstair: boolean;
  motel: boolean;
  status: boolean;
  xCoordinate: number;
  yCoordinate: number;
  postDTO: PostDTO;
  idDistrict: number;
}
