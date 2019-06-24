import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { UserProfileService } from '../../services/userProfile.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  profile = {};
  constructor(private httpClient : HttpClient, private userProfileService:UserProfileService) { }
  url : any;

  file : any;

  ngOnInit() {
    
  }

  /*this.userProfileService.getUserProfile().subscribe(profile => {

  });*/
  updateProfile() {
    console.log(this.profile);


3
4
5
 
const params = new FormData();

  params.append('customer',JSON.stringify( this.profile));
  params.append('file', this.file);
 

    var data = {
      customer : this.profile,
      file : this.file
    }

    this.userProfileService.postUserProfileWithFile(params).subscribe(profile => {

    });
    
    // this.userProfileService.postUserProfile(this.profile).subscribe(profile => {
      
    // });
  }

  onFileChange(event) {
    let reader = new FileReader();
    if(event.target.files && event.target.files.length > 0) {
      this.file = event.target.files[0];
      reader.readAsDataURL(this.file);
      reader.onload = (_event) => { 
        this.url = reader.result; 
      }
      console.log(this.file);
    }
  }

}
