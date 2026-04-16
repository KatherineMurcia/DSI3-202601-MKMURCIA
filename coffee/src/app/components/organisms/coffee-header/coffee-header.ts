import { Component } from '@angular/core';
import { AppLogo } from '../../atoms/app-logo/app-logo';
import { CoffeeNav } from '../../molecules/coffee-nav/coffee-nav';
import { SearchBar } from '../../molecules/search-bar/search-bar';

@Component({
  selector: 'app-coffee-header',
  imports: [AppLogo, CoffeeNav, SearchBar],
  templateUrl: './coffee-header.html',
  styleUrl: './coffee-header.css',
})
export class CoffeeHeader {}
