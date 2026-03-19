import { Component } from '@angular/core';
import { Header } from '../../components/header/header';

@Component({
  selector: 'app-game',
  imports: [Header],
  templateUrl: './game.html',
  styleUrl: './game.css',
})
export class Game {
  elements :number = 0;
  options : number [] = [];
  jugadores: string [] = ['ALICE', 'BOB', 'EMPATE'];


  generateElements (event: number) {
    let alicePoints = 0;
    let bobPoints = 0;
    let empate = 0;
      for (let juegos of this this.options) {
        consol
        const aliceElement = Math.floor(Math.random() * 100) + 1;
    console.log("El padre escuchó: ", event);
    this.elements = event;
    this.options = Array(event).fill(100);
  }
}

