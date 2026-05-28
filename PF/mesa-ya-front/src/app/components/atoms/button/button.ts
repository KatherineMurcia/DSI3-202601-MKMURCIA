import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.html',
  styleUrl: './button.css'
})
export class Button {
  type    = input<'button' | 'submit'>('button');
  variant = input<'primary' | 'secondary' | 'danger' | 'ghost'>('primary');
  disabled   = input(false);
  fullWidth  = input(false);
  clicked = output<void>();
}
