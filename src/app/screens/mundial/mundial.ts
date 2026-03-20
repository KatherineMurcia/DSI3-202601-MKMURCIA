import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-mundial',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './mundial.html',
  styleUrl: './mundial.css'
})
export class Mundial {
  cantidadPartidos: number = 0;

  partidos: { brasil: number | null; colombia: number | null; resultado: string }[] = [];

  generarPartidos(): void {
    if (this.cantidadPartidos < 1 || this.cantidadPartidos > 100) {
      alert('La cantidad de partidos debe estar entre 1 y 100');
      return;
    }

    this.partidos = [];

    for (let i = 0; i < this.cantidadPartidos; i++) {
      this.partidos.push({
        brasil: null,
        colombia: null,
        resultado: ''
      });
    }
  }

  calcularResultados(): void {
    for (let i = 0; i < this.partidos.length; i++) {
      const brasil = this.partidos[i].brasil;
      const colombia = this.partidos[i].colombia;

      if (brasil === null || colombia === null) {
        this.partidos[i].resultado = 'Completa los goles';
      } else if (colombia > brasil) {
        this.partidos[i].resultado = 'ganamos';
      } else if (colombia < brasil) {
        this.partidos[i].resultado = 'perdimos';
      } else {
        this.partidos[i].resultado = 'casi ganamos';
      }
    }
  }
}
