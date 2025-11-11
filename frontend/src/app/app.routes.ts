import {Routes } from '@angular/router';
import { ListComponent } from './list/list.component';
import { AppHome } from './home/home.component';

export const routes: Routes = [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', component: AppHome },
      { path: 'list', component: ListComponent },
];