import { Component, Input } from '@angular/core';
import { ButtonComponent } from '../../atoms/button/button';
import { LinkTextComponent } from '../../atoms/link-text/link-text';

@Component({
  selector: 'app-form-actions',
  standalone: true,
  imports: [ButtonComponent, LinkTextComponent],
  templateUrl: './form-actions.html',
  styleUrl: './form-actions.css'
})
export class FormActionsComponent {
  @Input() buttonLabel: string = 'Ingresar';
  @Input() linkText: string = '¿No tienes cuenta?';
  @Input() linkLabel: string = 'Regístrate';
}
