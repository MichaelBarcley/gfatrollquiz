import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  readonly rootUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  
}
