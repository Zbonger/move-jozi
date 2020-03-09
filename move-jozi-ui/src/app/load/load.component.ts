import {Component, OnInit} from '@angular/core';
import {LoadService} from "../services/load.service";
import {LoadModule} from "./module/load.module";

@Component({
  selector: 'app-load',
  templateUrl: './load.component.html',
  styleUrls: ['./load.component.scss']
})

export class LoadComponent implements OnInit {

  listOfLoadCatalogues: LoadModule[];

  constructor(private loadCatalogueService: LoadService) { }

  ngOnInit() {
    this.findAllServices();
  }

  private findAllServices() {
    this.loadCatalogueService.findAllLoads()
      .subscribe(data => {
        this.listOfLoadCatalogues = data;
        console.log(this.listOfLoadCatalogues);
    });
  }
}
