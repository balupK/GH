import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { routing } from './profile.routing';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';
import { ProfileComponent } from './profile.component';
import { FileUploadModule } from 'ng2-file-upload';
import {FormModule} from '../form/form.module';

@NgModule({
    imports: [
        CommonModule,
        SharedModule,
        FormsModule,
        routing,
        FileUploadModule
        // FormModule
    ],
    declarations: [
        ProfileComponent
    ]
})
export class ProfileModule { }
