import { Component } from '@angular/core';
import { NavbarComponent } from "./navbar/navbar.component";

@Component({
  standalone: true,
  selector: 'app-root',
  imports: [NavbarComponent],
  templateUrl: 'app.component.html',
  styleUrl: 'app.component.scss',

})
export class AppComponent {
  title = 'Phalanx';
}
