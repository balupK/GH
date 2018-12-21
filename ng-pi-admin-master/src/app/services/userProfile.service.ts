import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {environment} from './../../environments/environment'

@Injectable()
export class UserProfileService {

  BASE_URl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  getUserProfile() {
    return this.http.get(this.BASE_URl + "/profiles");
  }

  putUserProfile(profile) {
    return this.http.put(this.BASE_URl + "/profiles",profile);
  }

}