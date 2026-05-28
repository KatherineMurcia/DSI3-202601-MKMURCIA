import { Component, inject, computed } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Sidebar } from '../../components/organisms/sidebar/sidebar';
import { UserPill } from '../../components/molecules/user-pill/user-pill';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-dashboard-layout',
  imports: [RouterOutlet, Sidebar, UserPill],
  templateUrl: './dashboard-layout.html',
  styleUrl: './dashboard-layout.css'
})
export class DashboardLayout {
  authService = inject(AuthService);

  initials = computed(() => {
    const nombre = this.authService.currentUser()?.nombre ?? '';
    const parts = nombre.trim().split(/\s+/);
    if (parts.length === 1) return parts[0].charAt(0).toUpperCase();
    return (parts[0].charAt(0) + parts[parts.length - 1].charAt(0)).toUpperCase();
  });
}
