export class Education {

    id?: number;

    college: string;
    title: string;
    image: string;
    career: string;
    status: string;
    qualification: number;
    careerStart: string;
    careerEnd: string;

    constructor(college: string,
        title: string,
        image: string,
        career: string,
        status: string,
        qualification: number,
        careerStart: string,
        careerEnd: string) {
        this.college = college;
        this.title = title;
        this.image = image;
        this.career = career;
        this.status = status;
        this.qualification = qualification;
        this.careerStart = careerStart;
        this.careerEnd = careerEnd;
    }
}
