export class User {
  id: number;
  username: string;
  password: string;
  enabled: boolean;
  role: string;
  firstName: string;
  lastName: string;
  aboutMe: string;
  profileImageUrl: string;
  createDate: string;
  lastUpdate: string;

  constructor(
    id: number= 0,
    username: string= '',
    password: string= '',
    enabled: boolean= true,
    role: string= '',
    firstName: string= '',
    lastName: string= '',
    aboutMe: string= '',
    profileImageUrl: string= '',
    createDate: string= '',
    lastUpdate: string= ''
  ){
    this.id = id;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
    this.firstName = firstName;
    this.lastName = lastName;
    this.aboutMe = aboutMe;
    this.profileImageUrl = profileImageUrl;
    this.createDate = createDate;
    this.lastUpdate = lastUpdate;
  }
}
