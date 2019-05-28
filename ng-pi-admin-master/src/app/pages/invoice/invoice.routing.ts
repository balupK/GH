import { Routes, RouterModule } from '@angular/router';
import { InvoiceComponent } from './invoice.component';

const childRoutes: Routes = [
    {
        path: '',
        component: InvoiceComponent
    }
];

export const routing = RouterModule.forChild(childRoutes);
