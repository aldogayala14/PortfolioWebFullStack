export class Project {

    id?: number;

    name: string;
    image: string;
    projectStart: string;
    projectEnd: string;
    url: string;

    constructor(
        name: string,
        image: string,
        projectStart: string,
        projectEnd: string,
        url: string
    ) {
        this.name = name;
        this.image = image;
        this.projectStart = projectStart;
        this.projectEnd = projectEnd;
        this.url = url;

    }
}
