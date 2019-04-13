import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class GeocodingApiServiceService {
  API_URL: string;

  constructor(private http: HttpClient) {
    this.API_URL = 'https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyBKKUL9LFa4guJTQbouBA75Ypkd6G4DdD8&address=';
  }

  findFromAddress(address: string, postalCode?: string, place?: string, province?: string, region?: string, country?: string): Observable<any> {
    const compositeAddress = [address];

    if (postalCode) {
      compositeAddress.push(postalCode);
    }
    if (place) {
      compositeAddress.push(place);
    }
    if (province) {
      compositeAddress.push(province);
    }
    if (region) {
      compositeAddress.push(region);
    }
    if (country) {
      compositeAddress.push(country);
    }

    const url = `${this.API_URL}${compositeAddress.join(',')}`;

    return this.http.get(url).pipe(
      map(response => response as any)
    );
  }
}
