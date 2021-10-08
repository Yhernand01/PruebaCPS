import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaisService {
  constructor(private http : HttpClient) { }

  getPaises(): Observable<any>{
    const URL = "http://localhost:8080/api/paises";
    return this.http.get(URL);
  }

  getTarifa(idRegion: any): Observable<any>{
    const URL = `http://localhost:8080/api/tarifa/${idRegion}`
    return this.http.get(URL);
  }
}
