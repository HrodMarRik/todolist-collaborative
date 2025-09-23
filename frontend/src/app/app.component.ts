import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  template: `
    <div class="container">
      <h1>ToDoList Collaborative</h1>
      <p>Application de gestion de tâches collaboratives</p>
      <p>Projet prêt pour le développement</p>
      <div class="status">
        <h3>Status des Services</h3>
        <p>Backend: <span class="status-indicator">En attente de développement</span></p>
        <p>Frontend: <span class="status-indicator">En attente de développement</span></p>
        <p>Base de données: <span class="status-indicator">En attente de développement</span></p>
      </div>
    </div>
  `,
  styles: [`
    .container {
      max-width: 800px;
      margin: 50px auto;
      padding: 20px;
      text-align: center;
      font-family: Arial, sans-serif;
    }
    h1 {
      color: #2c3e50;
      margin-bottom: 20px;
    }
    .status {
      margin-top: 40px;
      padding: 20px;
      background-color: #f8f9fa;
      border-radius: 8px;
    }
    .status-indicator {
      color: #6c757d;
      font-style: italic;
    }
  `]
})
export class AppComponent {
  title = "todolist-collaborative";
}
