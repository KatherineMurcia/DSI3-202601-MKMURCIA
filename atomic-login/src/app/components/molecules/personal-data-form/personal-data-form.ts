import { Component } from '@angular/core';
import { InputFieldComponent } from '../../atoms/input-field/input-field';
import { SelectFieldComponent } from '../../atoms/select-field/select-field';

@Component({
  selector: 'app-personal-data-form',
  standalone: true,
  imports: [InputFieldComponent, SelectFieldComponent],
  templateUrl: './personal-data-form.html',
  styleUrl: './personal-data-form.css'
})
export class PersonalDataForm{
  carreras = ['Ingeniería de Sistemas', 'Ingeniería Industrial', 'Medicina', 'Diseño'];
}
