import { Routes } from '@angular/router';
import { LoginPageComponent } from './pages/login-page/login-page';

export const routes: Routes = [
  { path: 'auth/login', component: LoginPageComponent },
  { path: '', redirectTo: 'auth/login', pathMatch: 'full' }
];
