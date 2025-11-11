import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, Observable, of } from "rxjs";
import { environment } from "../../../environments/environment";
import { listInfo } from "../objects/listInfo";

@Injectable({
    providedIn: 'root'
})

export class listService {

    private readonly urlBaseClient = environment.apiUrl;

    constructor (private readonly http: HttpClient) {}

    getAllTable(): Observable<listInfo[]> {
        return this.http.get<listInfo[]>(this.urlBaseClient + `/list`).pipe(
            catchError(err => {
                console.error('erreur dans l\'appel');
                return of ([new listInfo('Nothing', 'Nothing', 'Nothing')]);
            })
        )
    }

    getTableInfo(id: string): Observable<listInfo> {
        return this.http.get<listInfo>(this.urlBaseClient + `/list/${id}`).pipe(
            catchError(err => {
                console.error('erreur dans l\'appel');
                return of( new listInfo ('Nothing', 'Nothing', 'Nothing'));
            })
        )
    }
}