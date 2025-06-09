import { Destination } from "./destination";
import { User } from "./user";

export class DiveSite {
  id: number;
  name: string;
  description: string;
  latitude: number;
  longitude: number;
  createDate: string;
  lastUpdate: string;
  addedBy: User;
  destination: Destination;

  constructor(
      id: number = 0,
  name: string = '',
  description: string = '',
  latitude: number = 0,
  longitude: number = 0,
  createDate: string = '',
  lastUpdate: string = '',
  addedBy: User = new User(),
  destination: Destination = new Destination(),
  ){
    this.id = id;
    this.name = name;
    this.description = description;
    this.latitude = latitude;
    this.longitude = longitude;
    this.createDate = createDate;
    this.lastUpdate = lastUpdate;
    this.addedBy = addedBy;
    this.destination = destination;
  }
}
