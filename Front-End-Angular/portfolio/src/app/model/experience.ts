export class Experience {

    id?: number;
    occupation:string;
    observations:string;
    image:string;
    occupationStart:string;
    occupationEnd: string;
    company:string;


    constructor(occupation:string, observations:string, image:string,occupationStart:string,occupationEnd:string, company:string){
        this.occupation = occupation;
        this.observations = observations;
        this.image = image;
        this.occupationStart= occupationStart;
        this.occupationEnd = occupationEnd;
        this.company = company;
    }

}
