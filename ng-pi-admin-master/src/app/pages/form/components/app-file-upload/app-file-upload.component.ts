import { Component, OnInit, ViewChild } from '@angular/core';
import { FileUploader } from 'ng2-file-upload';

const URL = 'URL';
//https://evening-anchorage-3159.herokuapp.com/api/1';

@Component({
  selector: 'app-file-upload',
  templateUrl: './app-file-upload.component.html',
  styleUrls: ['./app-file-upload.component.scss']
})
export class AppFileUploadComponent implements OnInit {

  constructor() { }
  @ViewChild('myInput')
  myInputVariable: ElementRef;
  
   @Input()
   url:string = 'https://evening-anchorage-3159.herokuapp.com/api1/';
  
  ngOnInit() { }

  public uploader: FileUploader = new FileUploader({ url: this.url });
  public hasBaseDropZoneOver: boolean = false;
  public hasAnotherDropZoneOver: boolean = false;

  public fileOverBase(e: any): void {
    this.hasBaseDropZoneOver = e;
  }

  public fileOverAnother(e: any): void {
    this.hasAnotherDropZoneOver = e;
  }
  uploadAll() {
    console.log("dgdf",this.uploader);
  }
  onChange() {
    if (this.uploader.queue.length > 1) {
      this.uploader.queue.shift();
    }
  }
}
import { Directive, ElementRef, Input, Renderer, OnChanges, SimpleChanges } from '@angular/core';

@Directive({
  selector: 'img[thumbnail]'
})
export class ThumbnailDirective {

  @Input() public image: any;

  constructor(private el: ElementRef, private renderer: Renderer) { }

  public ngOnChanges(changes: SimpleChanges) {

    let reader = new FileReader();
    let el = this.el;

    reader.onloadend = (readerEvent) => {
      let image :any  = new Image();
      image.onload = (imageEvent) => {
          // Resize the image
          let canvas = document.createElement('canvas');
          let maxSize = 700;
          let width = image.width;
          let height = image.height;
          if (width > height) {
              if (width > maxSize) {
                  height *= maxSize / width;
                  width = maxSize;
              }
          } else {
              if (height > maxSize) {
                  width *= maxSize / height;
                  height = maxSize;
              }
          }
          canvas.width = width;
          canvas.height = height;
          canvas.getContext('2d').drawImage(image, 0, 0, width, height);
          el.nativeElement.src = canvas.toDataURL('image/jpeg');
      };
      image.src = reader.result;
    };

    if (this.image) {
      return reader.readAsDataURL(this.image);
    }

  }

}