import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldComponent } from '../../atoms/input-field/input-field';
import { ErrorMessageComponent } from '../../atoms/error-message/error-message';

@Component({
  selector: 'app-credentials-form',
  standalone: true,
  imports: [CommonModule, InputFieldComponent, ErrorMessageComponent],
  templateUrl: './credentials-form.html',
  styleUrl: './credentials-form.css'
})
export class CredentialsFormComponent {
  showError = true;
}
