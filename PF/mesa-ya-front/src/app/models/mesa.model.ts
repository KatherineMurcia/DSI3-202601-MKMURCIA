export type EstadoMesa = 'Disponible' | 'Ocupada';

export interface Mesa {
  id: string;
  numero: number;
  capacidad: number;
  estado: EstadoMesa;
}
