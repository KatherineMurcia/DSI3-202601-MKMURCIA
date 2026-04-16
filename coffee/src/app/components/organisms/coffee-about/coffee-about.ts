import { Component } from '@angular/core';
import { AboutButtons } from '../../molecules/about-buttons/about-buttons';
import { RegisterFormAbout } from '../register-form-about/register-form-about';

@Component({
  selector: 'app-coffee-about',
  imports: [AboutButtons, RegisterFormAbout],
  templateUrl: './coffee-about.html',
  styleUrl: './coffee-about.css',
})
export class CoffeeAbout {}
