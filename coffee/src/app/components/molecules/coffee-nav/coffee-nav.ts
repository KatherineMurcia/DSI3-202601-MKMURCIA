import { Component, HostListener } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { LoginService } from '../../../services/login';

@Component({
  selector: 'app-coffee-nav',
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './coffee-nav.html',
  styleUrl: './coffee-nav.css',
})
export class CoffeeNav {
  dropdownOpen = false;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {}

  get isLoggedIn(): boolean {
    return this.loginService.isLoggedIn();
  }

  logout(): void {
    this.loginService.logout();
    this.router.navigate(['/']);
  }

  toggleDropdown(event: Event): void {
    event.stopPropagation();
    this.dropdownOpen = !this.dropdownOpen;
  }

  closeDropdown(): void {
    this.dropdownOpen = false;
  }

  @HostListener('document:click')
  onDocumentClick(): void {
    this.dropdownOpen = false;
  }
}
