export class JwtDto {
    token: string;
    username: string;
    password: string;

    constructor(token:string, username: string, password: string){
        this.token = token;
        this.username = username;
        this.password = password;
    }

    
}
