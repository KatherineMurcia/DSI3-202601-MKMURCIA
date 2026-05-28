import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-tab-bar',
  templateUrl: './tab-bar.html',
  styleUrl: './tab-bar.css'
})
export class TabBar {
  tabs         = input<{ label: string; value: string; count: number }[]>([]);
  active       = input('');
  activeChange = output<string>();
}
