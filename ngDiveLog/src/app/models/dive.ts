import { max } from "rxjs";
import { DiveSite } from "./dive-site";
import { User } from "./user";

export class Dive {
  id: number;
  user: User;
  diveSite: DiveSite;
  diveDate: string;
  timeIn: string;
  timeOut: string;
  maximumDepthMeters: number;
  decompressMinutes: number;
  notes: string;
  wildlifeSeen: string;
  weightKilograms: number;
  createDate: string;
  lastUpdate: string;

constructor(
    id: number = 0,
  user: User = new User(),
  diveSite: DiveSite = new DiveSite(),
  diveDate: string = '',
  timeIn: string = '',
  timeOut: string = '',
  maximumDepthMeters: number = 0,
  decompressMinutes: number = 0,
  notes: string = '',
  wildlifeSeen: string = '',
  weightKilograms: number = 0,
  createDate: string = '',
  lastUpdate: string = '',

){
  this.id = id;
  this.user = user;
  this.diveSite = diveSite;
  this.diveDate = diveDate;
  this.timeIn = timeIn;
  this.timeOut = timeOut;
  this.maximumDepthMeters = maximumDepthMeters;
  this.decompressMinutes = decompressMinutes;
  this.notes = notes;
  this.wildlifeSeen = wildlifeSeen;
  this.weightKilograms = weightKilograms;
  this.createDate = createDate;
  this.lastUpdate = lastUpdate;
}

}
