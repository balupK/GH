import { Component, OnInit } from '@angular/core';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.scss']
})
export class InvoiceComponent implements OnInit {

  isSelectedCustomer : boolean = false;

 customer : any;

  ngOnInit() {
  }

  displayInvoice(customer) {
    console.log("Main TS");
    console.log(customer);
    this.isSelectedCustomer = true;
    this.customer = customer;
  }

  invoicePageStatus(invoicePageStatus) {
    this.isSelectedCustomer = invoicePageStatus;
    this.customer = null;
  }

  /*rows = [new row()];
  subTotal = 0;
  shippingCharges= 0;
  Total = 0;
  gstAmount = 0;
  gTotal = 0;
  gstPercentage =0;
  constructor() { }
  add() {
    console.log(this.rows);
    this.rows.push(new row())
  }

  remove(u) {
    var idx = this.rows.indexOf(u);
    this.rows.splice(idx,1);
    this.addTotal();
  }

  addshippingCharges(shippingCharges) {
    this.shippingCharges = shippingCharges;
    this.addTotal();

  }
  addAmount(user){
    user.Amount = user.Price * user.Qty;
    
    this.addTotal();
  }
  addTotal (){
    this.Total = 0;
    this.subTotal = 0;   
    this.rows.forEach(u => {
      if (u.Amount != NaN) {
        this.subTotal += u.Amount;
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
*/
}

