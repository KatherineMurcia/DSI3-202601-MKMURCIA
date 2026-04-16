import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login';
import { User } from '../../models/user.interface';

@Component({
  selector: 'app-dashboard-screen',
  imports: [],
  templateUrl: './dashboard-screen.html',
  styleUrl: './dashboard-screen.css',
})
export class DashboardScreen implements OnInit {
  user: User | null = null;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.user = this.loginService.getLoggedUser();
    if (!this.user) {
      this.router.navigate(['/login']);
    }
  }

  logout(): void {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }
}
