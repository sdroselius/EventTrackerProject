export class User {
  id: number;
  username: string;
  password: string;
  enabled: boolean;
  role: string;
  firstName: string;
  lastName: string;
  profileImageUrl: string;
  aboutMe: string;
  createDate: string;
  lastUpdate: string;

  constructor(
  id: number = 0,
  username: string = '',
  password: string = '',
  enabled: boolean = true,
  role: string = '',
  firstName: string = '',
  lastName: string = '',
  profileImageUrl: string = '',
  aboutMe: string = '',
  createDate: string = '',
  lastUpdate: string = '',

  ){
    this.id = id;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
    this.firstName = firstName;
    this.lastName = lastName;
    this.profileImageUrl = profileImageUrl;
    this.aboutMe = aboutMe;
    this.createDate = createDate;
    this.lastUpdate = lastUpdate;
  }
}
