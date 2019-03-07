import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  readonly rootUrl = 'https://jsonplaceholder.typicode.com'
  constructor(private http: HttpClient) { }

  saveUser(username: string, email: string) {
    var body = {
      Username: username,
      Email: email
    }
    return this.http.post(this.rootUrl + '/todos/1', body);
  }

}



