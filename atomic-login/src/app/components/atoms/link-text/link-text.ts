import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-link-text',
  standalone: true,
  templateUrl: './link-text.html',
  styleUrl: './link-text.css'
})
export class LinkTextComponent {
  @Input() text: string = '¿No tienes cuenta?';
  @Input() linkLabel: string = 'Regístrate';
}
