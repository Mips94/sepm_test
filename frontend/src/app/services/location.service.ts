import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LocationSearch} from '../dtos/locationSearch';
import {Location} from '../dtos/location';
import {Globals} from '../global/globals';


@Injectable({
  providedIn: 'root'
})
export class LocationServiceService {
  private baseUri: string = this.globals.backendUri + '/locations';

  constructor(
    private http: HttpClient,
    private globals: Globals
  ) { }

  getLocations(): Observable<Location[]> {
    return this.http.get<Location[]>(this.baseUri);
  }

  saveLocation(loc: Location): Observable<Location> {
    return this.http.post<Location>(this.baseUri, loc);
  }

  updateLocation(loc: Location): Observable<Location> {
    return this.http.put<Location>(this.baseUri, loc);
  }

  deleteLocation(id: number): Observable<void> {
    return this.http.delete<void>(this.baseUri + '/' + id);
  }

  getLocation(id: number): Observable<Location> {
    return this.http.get<Location>(this.baseUri + '/' + id);
  }

  searchLocation(loc: LocationSearch): Observable<Location[]> {
    return this.http.post<Location[]>(this.baseUri+'/s', loc);
  }
}
