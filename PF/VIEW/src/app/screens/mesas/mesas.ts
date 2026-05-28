import { Component, signal, inject, computed } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MesaService } from '../../services/mesa.service';
import { Mesa } from '../../models/mesa.model';
import { TabBar } from '../../components/molecules/tab-bar/tab-bar';
import { MesaCard } from '../../components/molecules/mesa-card/mesa-card';
import { Button } from '../../components/atoms/button/button';

@Component({
  selector: 'app-mesas',
  imports: [FormsModule, TabBar, MesaCard, Button],
  templateUrl: './mesas.html',
  styleUrl: './mesas.css'
})
export class Mesas {
  service = inject(MesaService);
  mesas = this.service.mesas;

  filtro = signal<'todas' | 'Disponible' | 'Ocupada'>('todas');

  tabsConCuenta = computed(() => [
    { label: 'Todos',       value: 'todas',      count: this.mesas().length },
    { label: 'Disponibles', value: 'Disponible', count: this.mesas().filter(m => m.estado === 'Disponible').length },
    { label: 'Ocupadas',    value: 'Ocupada',    count: this.mesas().filter(m => m.estado === 'Ocupada').length },
  ]);

  mesasFiltradas = computed(() => {
    const f = this.filtro();
    const all = this.mesas();
    return f === 'todas' ? all : all.filter(m => m.estado === f);
  });

  onFiltroChange(v: string): void {
    this.filtro.set(v as 'todas' | 'Disponible' | 'Ocupada');
  }

  showModal   = signal(false);
  showConfirm = signal(false);
  isEditing   = signal(false);
  selectedId  = signal<string | null>(null);

  numero    = 0;
  capacidad = 0;

  openCreate(): void {
    this.numero = this.mesas().length + 1;
    this.capacidad = 4;
    this.isEditing.set(false);
    this.showModal.set(true);
  }

  openEdit(m: Mesa): void {
    this.selectedId.set(m.id);
    this.numero    = m.numero;
    this.capacidad = m.capacidad;
    this.isEditing.set(true);
    this.showModal.set(true);
  }

  save(): void {
    if (this.numero <= 0 || this.capacidad <= 0) return;
    if (this.isEditing()) {
      this.service.update(this.selectedId()!, this.numero, this.capacidad);
    } else {
      this.service.create(this.numero, this.capacidad);
    }
    this.showModal.set(false);
  }

  askDelete(m: Mesa): void {
    this.selectedId.set(m.id);
    this.showConfirm.set(true);
  }

  confirmDelete(): void {
    this.service.delete(this.selectedId()!);
    this.showConfirm.set(false);
  }
}
