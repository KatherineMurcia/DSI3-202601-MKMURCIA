export interface Producto {
  idProducto?: number;
  nombre: string;
  descripcion: string;
  precio: number;
  categoria: string;
  imagenUrl: string;
  disponible: boolean;
  stock: number;
}

export const CATEGORIAS = ['Entradas', 'Platos Fuertes', 'Postres', 'Bebidas', 'Ensaladas', 'Sopas', 'Otros'];
