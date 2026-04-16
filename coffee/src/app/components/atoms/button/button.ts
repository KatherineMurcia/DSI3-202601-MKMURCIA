import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-button',
  imports: [],
  templateUrl: './button.html',
  styleUrl: './button.css',
})
export class Button {
  @Input() label: string = 'Enviar';
  @Input() type: string = 'button';
  @Input() variant: string = 'primary';
  @Output() clicked = new EventEmitter<void>();
}
