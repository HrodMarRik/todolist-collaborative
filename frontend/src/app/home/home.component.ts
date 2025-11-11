import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  standalone: true,
  selector: 'app-home',
  imports: [NavbarComponent],
  templateUrl: 'home.component.html',

})
export class AppHome {}