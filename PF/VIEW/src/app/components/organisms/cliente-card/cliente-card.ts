import { Component, input, output } from '@angular/core';
import { Cliente } from '../../../models/cliente.model';

@Component({
  selector: 'app-cliente-card',
  templateUrl: './cliente-card.html',
  styleUrl: './cliente-card.css'
})
export class ClienteCard {
  cliente = input.required<Cliente>();
  editClick = output<void>();
  deleteClick = output<void>();

  initials(): string {
    const nombre = this.cliente().nombre;
    const parts = nombre.trim().split(/\s+/);
    if (parts.length === 1) return parts[0].charAt(0).toUpperCase();
    return (parts[0].charAt(0) + parts[parts.length - 1].charAt(0)).toUpperCase();
  }
}
