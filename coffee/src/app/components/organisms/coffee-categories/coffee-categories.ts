import { Component, OnInit, OnDestroy, ElementRef, ViewChild, AfterViewInit } from '@angular/core';
import { CoffeeCard } from '../../molecules/coffee-card/coffee-card';

@Component({
  selector: 'app-coffee-categories',
  imports: [CoffeeCard],
  templateUrl: './coffee-categories.html',
  styleUrl: './coffee-categories.css',
})
export class CoffeeCategories implements OnInit, OnDestroy {
  categories = [
    { image: 'images/bebidasCalientes.png', title: 'Bebidas calientes' },
    { image: 'images/bebidasFrias.jpg', title: 'Bebidas frías' },
    { image: 'images/postres.jpg', title: 'Postres' },
    { image: 'images/panaderia.jpg', title: 'Panadería' },
    { image: 'images/galletas.jpg', title: 'Galletas' },
    { image: 'images/pedidoPersonalizado.jpg', title: 'Pedido personalizado' },
  ];

  currentIndex = 0;
  slideOffset = 0;
  private intervalId: any;
  private readonly visibleItems = 4;
  private readonly slideWidth = 270; // approx card width + gap

  get dots(): number[] {
    return Array(this.categories.length - this.visibleItems + 1).fill(0);
  }

  ngOnInit(): void {
    this.intervalId = setInterval(() => this.nextSlide(), 3000);
  }

  ngOnDestroy(): void {
    clearInterval(this.intervalId);
  }

  nextSlide(): void {
    const maxIndex = this.categories.length - this.visibleItems;
    this.currentIndex = this.currentIndex >= maxIndex ? 0 : this.currentIndex + 1;
    this.slideOffset = this.currentIndex * this.slideWidth;
  }

  goToSlide(index: number): void {
    this.currentIndex = index;
    this.slideOffset = this.currentIndex * this.slideWidth;
  }
}
