import { Component } from '@angular/core';
import { Header } from '../../../components/organisms/header/header';

@Component({
  selector: 'app-main-layout',
  imports: [Header],
  templateUrl: './main-layout.html',
  styleUrl: './main-layout.css',
})
export class MainLayout {}
