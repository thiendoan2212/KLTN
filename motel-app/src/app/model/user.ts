export class User {
  id: number;
  username: string;
  email: string;
  address: string;
  phone: string;
  block: boolean;

  constructor(id: number, username: string, email: string, address: string, phone: string, block: boolean) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.address = address;
    this.phone = phone;
    this.block = block;
  }
}
