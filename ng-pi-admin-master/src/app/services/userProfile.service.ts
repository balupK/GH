import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {environment} from './../../environments/environment'

@Injectable()
export class UserProfileService {

  BASE_URl = environment.apiBaseUrl;
  constructor(private http: Http) { }

  getUserProfile() {
    return this.http.get(this.BASE_URl + "/profiles");
  }

}