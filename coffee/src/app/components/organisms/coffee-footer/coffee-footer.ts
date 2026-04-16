import { Component } from '@angular/core';
import { SocialLinks } from '../../molecules/social-links/social-links';

@Component({
  selector: 'app-coffee-footer',
  imports: [SocialLinks],
  templateUrl: './coffee-footer.html',
  styleUrl: './coffee-footer.css',
})
export class CoffeeFooter {}
