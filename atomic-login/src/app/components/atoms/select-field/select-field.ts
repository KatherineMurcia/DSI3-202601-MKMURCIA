import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-select-field',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './select-field.html',
  styleUrl: './select-field.css'
})
export class SelectFieldComponent {
  @Input() label: string = '';
  @Input() options: string[] = [];
}
