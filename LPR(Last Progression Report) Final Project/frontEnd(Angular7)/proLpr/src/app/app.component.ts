import { Component } from '@angular/core';
import { RestService } from './services/rest.service';
import { TextReadComponent } from './text-read/text-read.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'proLPR';
  text: Object;
  constructor(private abc: RestService) { }

    getData(){
    this.abc.getText().subscribe(abc=>this.text=abc);
  }
  
  

}
