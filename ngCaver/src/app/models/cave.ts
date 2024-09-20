export class Cave {
  id: number;
  name: string;
  imageUrl: string;
  description: string;
  enabled: boolean;
  exploredLengthKm: number;
  entranceAuthority: string;
  createDate: string | undefined;
  lastUpdate: string | undefined;

  constructor(
    id: number = 0,
    name: string = '',
    imageUrl: string = '',
    description: string = '',
    enabled: boolean = true,
    exploredLengthKm: number = 0,
    entranceAuthority: string = '',
    createDate: string = '',
    lastUpdate: string = ''
  ) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.description = description;
    this.enabled = enabled;
    this.exploredLengthKm = exploredLengthKm;
    this.entranceAuthority = entranceAuthority;
    this.createDate = createDate;
    this.lastUpdate = lastUpdate;
  }
}
