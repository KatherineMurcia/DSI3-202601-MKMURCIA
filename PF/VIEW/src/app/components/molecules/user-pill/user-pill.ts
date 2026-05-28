import { Component, input } from '@angular/core';

@Component({
  selector: 'app-user-pill',
  templateUrl: './user-pill.html',
  styleUrl: './user-pill.css'
})
export class UserPill {
  initials = input('');
  name     = input('');
}
