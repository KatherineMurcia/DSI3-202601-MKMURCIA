import { Component, input, model } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-input-field',
  imports: [FormsModule],
  templateUrl: './input-field.html',
  styleUrl: './input-field.css'
})
export class InputField {
  label = input('');
  type = input('text');
  placeholder = input('');
  name = input('field');
  required = input(false);
  value = model('');
}
