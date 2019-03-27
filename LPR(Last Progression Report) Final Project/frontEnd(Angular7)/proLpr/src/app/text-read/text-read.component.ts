import { Component, OnInit } from '@angular/core';
import { RestService } from '../services/rest.service';
import { Router } from '@angular/router';
import {NgForm} from '@angular/forms';
import { Observable,of } from 'rxjs';
import { Project } from '../shared/model/project';

@Component({
  selector: 'app-text-read',
  templateUrl: './text-read.component.html',
  styleUrls: ['./text-read.component.css']
})

export class TextReadComponent{

  myserv: {};
  myser: {};
  error:any;
  
  
  constructor(private pqr: RestService) { }

    getClassData(){
    this.pqr.getClassText().subscribe(pqr => this.myserv = pqr);
  }
  //this method is called when user press submit button
   getClassDataId(listFilter:string){
    this.pqr.getClassTextId(listFilter).subscribe(xyz => this.myser = xyz,err=>{this.error=err;console.log("err",err)});

  }
  }

    

