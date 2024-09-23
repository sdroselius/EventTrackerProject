import { Cave } from "./cave";
import { User } from "./user";

export class CaveVisit {
  id: number;
  title: string;
  dateIn: string;
  dateOut: string;
  timeIn: string;
  timeOut: string;
  verticalDepthReachedMeters: number;
  verticalDepthOnRopeMeters: string;
  notes: string;
  createDate: string | undefined;
  lastUpdate: string | undefined;
  cave: Cave;
  user: User;

  constructor(
    id: number = 0,
    title: string = '',
    dateIn: string = '',
    dateOut: string = '',
    timeIn: string = '',
    timeOut: string = '',
    verticalDepthReachedMeters: number = 0,
    verticalDepthOnRopeMeters: string = '',
    notes: string = '',
    createDate: string = '',
    lastUpdate: string = '',
    cave: Cave = new Cave(),
    user: User = new User()
  ) {
    this.id = id;
    this.title = title;
    this.dateIn = dateIn;
    this.dateOut = dateOut;
    this.timeIn = timeIn;
    this.timeOut = timeOut;
    this.verticalDepthReachedMeters = verticalDepthReachedMeters;
    this.verticalDepthOnRopeMeters = verticalDepthOnRopeMeters;
    this.notes = notes;
    this.createDate = createDate;
    this.lastUpdate = lastUpdate;
    this.cave = cave;
    this.user = user;
  }
}
