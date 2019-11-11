import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {ViewModel} from "./view-model";

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private readonly searchUrl: string;
  constructor(private http: HttpClient) {
    this.searchUrl = 'http://localhost:8080/flight/search';
  }

  public searchFlight(params: HttpParams): Observable<ViewModel> {
    return this.http.get<ViewModel>(this.searchUrl, { params });
  }
}
