import { Component } from '@angular/core';
import { NavbarComponent } from "./navbar/navbar.component";
import { RouterOutlet } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-root',
  imports: [RouterOutlet, NavbarComponent],
  templateUrl: 'app.component.html',
  styleUrl: 'app.component.scss',

})
export class AppComponent {
  title = 'Phalanx';
}
