import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserProfileService } from '../../services/userProfile.service'

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  profile = {};
  constructor(private httpClient : HttpClient, private userProfileService:UserProfileService) { }

  ngOnInit() {
    
  }

  /*this.userProfileService.getUserProfile().subscribe(profile => {

  });*/
  updateProfile() {
    console.log(this.profile);
    this.userProfileService.postUserProfile(this.profile).subscribe(profile => {
      
    });
  }

}
