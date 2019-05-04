import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map, skip} from 'rxjs/operators';
import {RequestOptions} from '@angular/http';


@Injectable({
  providedIn: 'root'
})
export class GeocodingApiServiceService {
  API_URL: string;
  data: any;

  constructor(private http: HttpClient) {
    this.API_URL = 'https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyBKKUL9LFa4guJTQbouBA75Ypkd6G4DdD8&address=';
  }

  // findFromAddress(address: string, postalCode?: string, place?: string, province?: string, region?: string, country?: string): Observable<any> {
  //     const compositeAddress = [address];
//   if (postalCode) {
//     compositeAddress.push(postalCode);
//   }
//   if (place) {
//     compositeAddress.push(place);
//   }
//   if (province) {
//     compositeAddress.push(province);
//   }
//   if (region) {
//     compositeAddress.push(region);
//   }
//   if (country) {
//     compositeAddress.push(country);
//   }
//
//   const url = `${this.API_URL}${compositeAddress.join(',')}`;
//
//   return this.http.get(url).pipe(
//     map(response => response as any)
// );
  //   const url = this.API_URL + address;
  //   return this.http.get(url);
  // }

  findFromAddress(address: string) {
    const url = this.API_URL + address;
    fetch(url)
      .then(response => {
        if (response.ok) {
          return response.json();
        } else {
          return Promise.reject({
            status: response.status,
            statusText: response.statusText
          });
        }
      })
      .then(data => {
        this.data = data;
        return data;
      })
      .catch(error => {
        console.log('error', error);
      });
    return this.data;
  }
}
