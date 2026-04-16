import { Component } from '@angular/core';
import { CoffeeBanner } from '../../components/organisms/coffee-banner/coffee-banner';
import { CoffeeCategories } from '../../components/organisms/coffee-categories/coffee-categories';
import { CoffeeAbout } from '../../components/organisms/coffee-about/coffee-about';
import { CoffeeFooter } from '../../components/organisms/coffee-footer/coffee-footer';

@Component({
  selector: 'app-coffee-screen',
  imports: [CoffeeBanner, CoffeeCategories, CoffeeAbout, CoffeeFooter],
  templateUrl: './coffee-screen.html',
  styleUrl: './coffee-screen.css',
})
export class CoffeeScreen {
  
}
