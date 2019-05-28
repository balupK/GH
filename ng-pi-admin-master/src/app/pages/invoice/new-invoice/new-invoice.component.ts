import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { UserProfileService } from '../../../services/userProfile.service';
import * as jspdf from 'jspdf';  
  
import html2canvas from 'html2canvas';  

@Component({
  selector: 'app-new-invoice',
  templateUrl: './new-invoice.component.html',
  styleUrls: ['./new-invoice.component.scss']
})
export class NewInvoiceComponent implements OnInit {

  private customerExists : boolean;

  private customer : any;

  rows = [new row()];
  subTotal = 0;
  shippingCharges= 0;
  Total = 0;
  gstAmount = 0;
  gTotal = 0;
  gstPercentage =0;

  @Output('isInvoicePageOpen')
  isInvoicePageOpen = new EventEmitter();
  //@Input('customerDetail')
  //customerDetail : any;

  //@Input('isCustomerSelected')
  //isCustomerSelected: boolean ;

  get isCustomerSelected() : boolean {
    return this.customerExists;
  }

  @Input()
  set isCustomerSelected (val : boolean) {

    this.customerExists = val;
  }

  get customerDetail() : any {
    return this.customer;
  }
  @Input()
  set customerDetail (val : any) {

    this.customer = val;
  }

  constructor(private userProfileService:UserProfileService) { }

  ngOnInit() {
    console.log(this.customerDetail);
  }

  
  
  add() {
    this.rows.push(new row())
  }

  remove(u) {
    var idx = this.rows.indexOf(u);
    if (this.rows.length > 1) {
      this.rows.splice(idx,1);
      this.addTotal();
    }
  }

  addshippingCharges(shippingCharges) {
    this.shippingCharges = shippingCharges;
    this.addTotal();

  }
  addAmount(row){
    row.amount = row.price * row.qty;
    
    this.addTotal();
  }
  addTotal (){
    this.Total = 0;
    this.subTotal = 0;   
    this.rows.forEach(u => {
      if (u.amount != NaN && u.amount > 0) {
        this.subTotal += u.amount;
      }
    });
    if (this.subTotal != NaN) {
      this.Total += this.subTotal;
    }
    if (this.shippingCharges > 0) {
      this.Total += this.shippingCharges;
    }
    this.addGst(this.gstPercentage);
  }

  addGst(gstValue){
    this.gstPercentage = gstValue;
    this.gstAmount = (this.Total * gstValue) / 100 ;
    this.gTotal = this.Total + this.gstAmount;
  }

  cancelInvoice() {
    this.customerExists = false;
    this.isInvoicePageOpen.emit(false);
  }

  save(){
    var result = {
      "rows": this.rows,
      "total" :this.Total,
      "subTotal" : this.subTotal,
      "shippingCharges" : this.shippingCharges,
      "gstPercentage" : this.gstPercentage,
      "gstAmount" : this.gstAmount,
      "gTotal" : this.gTotal
    }
    console.log(JSON.stringify(result));

    var data = document.getElementById('invoiceBill');  
    html2canvas(data).then(canvas => {  
      var imgWidth = 208;   
      var pageHeight = 295;    
      var imgHeight = canvas.height * imgWidth / canvas.width;  
      var heightLeft = imgHeight;  
  
      const contentDataURL = canvas.toDataURL('image/png')  
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF  
      var position = 0;  
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)  
      pdf.save('MYPdf.pdf');
    }); 

    this.userProfileService.postInvoice(result).subscribe(result => {
      console.log(result);
    });
  }
}

class row {
  sno;
  itemDetails;
  qty :number;
  price : number;
  amount : number;
}