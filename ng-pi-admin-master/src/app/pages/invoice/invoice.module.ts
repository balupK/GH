import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { routing } from './invoice.routing';
import { SharedModule } from '../../shared/shared.module';
import { InvoiceComponent } from './invoice.component';
import { FormsModule } from '@angular/forms';
import { SelectCustomerComponent } from './select-customer/select-customer.component';
import { NewInvoiceComponent } from './new-invoice/new-invoice.component';
import { TableModule } from './../table/table.module'

@NgModule({
    imports: [
        CommonModule,
        SharedModule,
        routing,
        FormsModule,
        TableModule
    ],
    declarations: [
        InvoiceComponent,
        SelectCustomerComponent,
        NewInvoiceComponent
    ]
})
export class InvoiceModule { }
