export class Person {

    id?: number;
    firstName: string;
    lastName: string;
    birthDate: string;
    email: string;
    nationality: string;
    aboutMe: string;
    occupation: string;
    imageBackgroundHeader: string;
    imageProfile: string;

    constructor(firstName: string,
        lastName: string,
        birthDate: string,
        email: string,
        nationality: string,
        aboutMe: string,
        occupation: string,
        imageBackgroundHeader: string,
        imageProfile: string){

            this.firstName= firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
            this.email = email;
            this.nationality = nationality;
            this.aboutMe = aboutMe;
            this.occupation = occupation;
            this.imageBackgroundHeader = imageBackgroundHeader;
            this.imageProfile = imageProfile;

        }


}
