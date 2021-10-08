import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) {}

  getCliente(codigo: any): Observable<any>{
    const url = `http://localhost:8080/api/cliente/${codigo}`;
    return this.http.get(url);
  }
}