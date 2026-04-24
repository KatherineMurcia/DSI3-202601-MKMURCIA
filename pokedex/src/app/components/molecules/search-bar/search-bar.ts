import { Component, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-bar',
  imports: [CommonModule, FormsModule],
  templateUrl: './search-bar.html',
  styleUrl: './search-bar.css',
})
export class SearchBar {
  query: string = '';

  @Output() search = new EventEmitter<string>();

  onSearch(): void {
    if (this.query.trim()) {
      this.search.emit(this.query.trim());
    }
  }
}
