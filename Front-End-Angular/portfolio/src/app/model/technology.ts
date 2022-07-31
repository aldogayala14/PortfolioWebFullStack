export class Technology {

    id?: number;

    name: string;
    percentageKnowledge: number;

    constructor(name: string, percentageKnowledge: number) {
        this.name = name;
        this.percentageKnowledge = percentageKnowledge;
    }
}
