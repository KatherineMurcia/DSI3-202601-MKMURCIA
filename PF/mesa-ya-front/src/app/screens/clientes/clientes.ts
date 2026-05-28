import { Component, signal, inject, computed } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ClienteService } from '../../services/cliente.service';
import { Cliente } from '../../models/cliente.model';
import { SearchBar } from '../../components/molecules/search-bar/search-bar';
import { ClienteCard } from '../../components/molecules/cliente-card/cliente-card';
import { Button } from '../../components/atoms/button/button';

@Component({
  selector: 'app-clientes',
  imports: [FormsModule, SearchBar, ClienteCard, Button],
  templateUrl: './clientes.html',
  styleUrl: './clientes.css'
})
export class Clientes {
  service = inject(ClienteService);

  query = signal('');
  clientes = computed(() => {
    const q = this.query();
    return q ? this.service.search(q) : this.service.getAll();
  });

  showModal   = signal(false);
  showConfirm = signal(false);
  isEditing   = signal(false);
  selectedId  = signal<string | null>(null);

  nombre   = '';
  correo   = '';
  telefono = '';

  openCreate(): void {
    this.nombre = '';
    this.correo = '';
    this.telefono = '';
    this.isEditing.set(false);
    this.showModal.set(true);
  }

  openEdit(c: Cliente): void {
    this.selectedId.set(c.id);
    this.nombre   = c.nombre;
    this.correo   = c.correo;
    this.telefono = c.telefono;
    this.isEditing.set(true);
    this.showModal.set(true);
  }

  save(): void {
    if (!this.nombre || !this.correo) return;
    if (this.isEditing()) {
      this.service.update(this.selectedId()!, this.nombre, this.correo, this.telefono);
    } else {
      this.service.create(this.nombre, this.correo, this.telefono);
    }
    this.showModal.set(false);
  }

  askDelete(c: Cliente): void {
    this.selectedId.set(c.id);
    this.showConfirm.set(true);
  }

  confirmDelete(): void {
    this.service.delete(this.selectedId()!);
    this.showConfirm.set(false);
  }
}
