import { Routes } from '@angular/router';
import { authGuard } from './services/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'auth/login', pathMatch: 'full' },
  {
    path: 'auth',
    loadComponent: () => import('./templates/auth-layout/auth-layout').then(m => m.AuthLayout),
    children: [
      { path: 'login',    loadComponent: () => import('./screens/login/login').then(m => m.Login) },
      { path: 'register', loadComponent: () => import('./screens/register/register').then(m => m.Register) },
      { path: '', redirectTo: 'login', pathMatch: 'full' }
    ]
  },
  {
    path: 'app',
    loadComponent: () => import('./templates/dashboard-layout/dashboard-layout').then(m => m.DashboardLayout),
    canActivate: [authGuard],
    children: [
      { path: '',          redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', loadComponent: () => import('./screens/dashboard/dashboard').then(m => m.Dashboard) },
      { path: 'productos', loadComponent: () => import('./screens/productos/productos').then(m => m.Productos) },
      { path: 'mesas',     loadComponent: () => import('./screens/mesas/mesas').then(m => m.Mesas) },
      { path: 'clientes',  loadComponent: () => import('./screens/clientes/clientes').then(m => m.Clientes) },
      { path: 'pedidos',   loadComponent: () => import('./screens/pedidos/pedidos').then(m => m.Pedidos) },
    ]
  },
  { path: '**', redirectTo: 'auth/login' }
];
