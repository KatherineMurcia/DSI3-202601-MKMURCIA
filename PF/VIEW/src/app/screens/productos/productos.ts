import { Component, OnInit, signal, inject, computed } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProductoService } from '../../services/producto.service';
import { Producto, CATEGORIAS } from '../../models/producto.model';
import { SearchBar } from '../../components/molecules/search-bar/search-bar';
import { ProductoCard } from '../../components/molecules/producto-card/producto-card';
import { Button } from '../../components/atoms/button/button';

@Component({
  selector: 'app-productos',
  imports: [FormsModule, SearchBar, ProductoCard, Button],
  templateUrl: './productos.html',
  styleUrl: './productos.css'
})
export class Productos implements OnInit {
  private service = inject(ProductoService);

  productos  = signal<Producto[]>([]);
  busqueda   = signal('');
  categorias = CATEGORIAS;
  loading    = signal(true);
  error      = signal('');

  filtered = computed(() => {
    const q = this.busqueda().toLowerCase().trim();
    const all = this.productos();
    if (!q) return all;
    return all.filter(p =>
      p.nombre.toLowerCase().includes(q) || p.categoria.toLowerCase().includes(q)
    );
  });

  showModal   = signal(false);
  isEditing   = signal(false);
  showConfirm = signal(false);
  selectedId  = signal<number | null>(null);

  form: Omit<Producto, 'idProducto'> = this.emptyForm();

  private emptyForm(): Omit<Producto, 'idProducto'> {
    return { nombre: '', descripcion: '', precio: 0, categoria: '', imagenUrl: '', disponible: true, stock: 0 };
  }

  ngOnInit(): void { this.load(); }

  load(): void {
    this.loading.set(true);
    this.service.getAll().subscribe({
      next:  (data) => { this.productos.set(data); this.loading.set(false); },
      error: ()     => { this.error.set('No se pudo conectar con api-productos (puerto 9000).'); this.loading.set(false); }
    });
  }

  openCreate(): void {
    this.form = this.emptyForm();
    this.isEditing.set(false);
    this.showModal.set(true);
  }

  openEdit(p: Producto): void {
    this.selectedId.set(p.idProducto!);
    this.form = { nombre: p.nombre, descripcion: p.descripcion, precio: p.precio, categoria: p.categoria, imagenUrl: p.imagenUrl, disponible: p.disponible, stock: p.stock };
    this.isEditing.set(true);
    this.showModal.set(true);
  }

  closeModal(): void { this.showModal.set(false); }

  save(): void {
    if (!this.form.nombre || !this.form.categoria || this.form.precio <= 0) return;
    if (this.isEditing()) {
      this.service.update(this.selectedId()!, this.form).subscribe({ next: () => { this.closeModal(); this.load(); } });
    } else {
      this.service.create(this.form).subscribe({ next: () => { this.closeModal(); this.load(); } });
    }
  }

  askDelete(p: Producto): void {
    this.selectedId.set(p.idProducto!);
    this.showConfirm.set(true);
  }

  confirmDelete(): void {
    this.service.delete(this.selectedId()!).subscribe({ next: () => { this.showConfirm.set(false); this.load(); } });
  }
}
