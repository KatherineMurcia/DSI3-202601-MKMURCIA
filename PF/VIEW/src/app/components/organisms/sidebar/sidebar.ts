import { Component, inject } from '@angular/core';
import { RouterLink, RouterLinkActive, Router } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
import { AppLogo } from '../../atoms/app-logo/app-logo';

@Component({
  selector: 'app-sidebar',
  imports: [RouterLink, RouterLinkActive, AppLogo],
  templateUrl: './sidebar.html',
  styleUrl: './sidebar.css'
})
export class Sidebar {
  private auth = inject(AuthService);
  private router = inject(Router);

  user = this.auth.currentUser;

  navItems = [
    { label: 'Dashboard', path: '/app/dashboard' },
    { label: 'Productos',  path: '/app/productos' },
    { label: 'Mesas',      path: '/app/mesas'     },
    { label: 'Clientes',   path: '/app/clientes'  },
    { label: 'Pedidos',    path: '/app/pedidos'   },
  ];

  logout(): void {
    this.auth.logout();
    this.router.navigate(['/auth/login']);
  }
}
