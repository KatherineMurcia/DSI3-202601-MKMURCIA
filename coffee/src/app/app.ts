import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CoffeeHeader } from './components/organisms/coffee-header/coffee-header';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CoffeeHeader],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('coffee');
}
