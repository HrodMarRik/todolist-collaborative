import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";
import { listInfo } from '../objects/listInfo';
import { listService } from '../services/listService';

@Component({
  selector: 'app-list',
  standalone: true,
  imports: [NavbarComponent],
  templateUrl: './list.component.html',
  styleUrl: './list.component.scss'
})
export class ListComponent implements OnInit{

    AllTables: listInfo[] = [];

    constructor(private listService: listService) { }

    ngOnInit(){
        this.getAllTables();
    }

    getAllTables(){
        this.listService.getAllTable().subscribe(data => (this.AllTables = data));
    }

}
