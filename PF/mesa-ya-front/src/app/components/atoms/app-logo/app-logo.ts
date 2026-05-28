import { Component, input } from '@angular/core';

@Component({
  selector: 'app-logo',
  templateUrl: './app-logo.html',
  styleUrl: './app-logo.css'
})
export class AppLogo {
  inverted = input(false);
}
