import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-app-logo',
  imports: [],
  templateUrl: './app-logo.html',
  styleUrl: './app-logo.css',
})
export class AppLogo {
  @Input() src: string = '';
  @Input() alt: string = 'Logo';
}
