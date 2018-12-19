import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserProfileService } from '../../services/userProfile.service'

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor(private httpClient : HttpClient, private userProfileService:UserProfileService) { }

  ngOnInit() { }

}
