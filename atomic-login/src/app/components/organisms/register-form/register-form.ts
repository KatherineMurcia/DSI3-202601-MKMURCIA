import { Component } from '@angular/core';
import { RegisterHeader } from '../../molecules/register-header/register-header';
import { PersonalDataForm } from '../../molecules/personal-data-form/personal-data-form';
import { FormActionsComponent } from '../../molecules/form-actions/form-actions';

@Component({
  selector: 'app-register-form',
  standalone: true,
  imports: [RegisterHeader, PersonalDataForm, FormActionsComponent],
  templateUrl: './register-form.html',
  styleUrl: './register-form.css'
})
export class RegisterFormComponent {}
