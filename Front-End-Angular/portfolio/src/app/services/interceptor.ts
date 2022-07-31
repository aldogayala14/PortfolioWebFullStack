import { HttpEvent, HttpHandler, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { TokenService } from "./token.service";

@Injectable({
    providedIn:'root'
})
export class Interceptor {

    constructor(private tokenService: TokenService){

    }

    public intercept(httpRequest: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<HttpEvent<any>>>{
            let inReq = httpRequest;
            const token = this.tokenService.getToken();
            if(token != null){
                inReq = httpRequest.clone({
                    headers: httpRequest.headers.set('Authorization', 'Bearer' + token)
                });
            }

            return next.handle(inReq);
    }
}

export const InterceptorProvider = [{
    provide: HTTP_INTERCEPTORS,
    useClass: Interceptor,
    multi: true
}];
