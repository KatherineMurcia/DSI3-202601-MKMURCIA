import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-link-text',
  imports: [],
  templateUrl: './link-text.html',
  styleUrl: './link-text.css',
})
export class LinkText {
  @Input() text: string = '';
  @Input() linkLabel: string = '';
  @Output() linkClicked = new EventEmitter<void>();
}
