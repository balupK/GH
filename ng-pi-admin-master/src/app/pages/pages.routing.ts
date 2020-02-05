import { Routes, RouterModule } from '@angular/router';
import { PagesComponent } from './pages.component';
import { LoginComponent } from './login/login.component';

export const childRoutes: Routes = [
    {
        path: 'login',
        component: LoginComponent,
    },
    {
        path: 'pages',
        component: PagesComponent,
        children: [
            { path: '', redirectTo: 'index', pathMatch: 'full' },
            { path: 'index', loadChildren: () => import('./index/index.module').then(m => m.IndexModule) },
            { path: 'editor', loadChildren: () => import('./editor/editor.module').then(m => m.EditorModule) },
            { path: 'icon', loadChildren: () => import('./icon/icon.module').then(m => m.IconModule) },
            { path: 'Invoice', loadChildren: () => import('./invoice/invoice.module').then(m => m.InvoiceModule) },
            { path: 'profile', loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule) },
            { path: 'form', loadChildren: () => import('./form/form.module').then(m => m.FormModule) },
            { path: 'charts', loadChildren: () => import('./charts/charts.module').then(m => m.ChartsModule) },
            { path: 'ui', loadChildren: () => import('./ui/ui.module').then(m => m.UIModule) },
            { path: 'table', loadChildren: () => import('./table/table.module').then(m => m.TableModule) },
            { path: 'menu-levels', loadChildren: () => import('./menu-levels/menu-levels.module').then(m => m.MenuLevelsModule) },
        ]
    }
];

export const routing = RouterModule.forChild(childRoutes);
