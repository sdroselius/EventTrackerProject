import { CaveVisit } from "./cave-visit";
import { FormationType } from "./formation-type";
import { User } from "./user";

export class Cave {
  id: number;
  name: string;
  imageUrl: string;
  description: string;
  enabled: boolean;
  exploredLengthKm: number;
  entranceAuthority: string;
  formationType: FormationType;
  createDate: string | undefined;
  lastUpdate: string | undefined;
  user: User;
  caveVisits: CaveVisit[] | null | undefined;

  constructor(
    id: number = 0,
    name: string = '',
    imageUrl: string = '',
    description: string = '',
    enabled: boolean = true,
    exploredLengthKm: number = 0,
    entranceAuthority: string = '',
    formationType: FormationType = new FormationType(),
    createDate: string = '',
    lastUpdate: string = '',
    user: User = new User(),
    caveVisits: CaveVisit[] = []
  ) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.description = description;
    this.enabled = enabled;
    this.exploredLengthKm = exploredLengthKm;
    this.entranceAuthority = entranceAuthority;
    this.formationType = formationType;
    this.createDate = createDate;
    this.lastUpdate = lastUpdate;
    this.user = user;
    this.caveVisits = caveVisits;
  }
}
