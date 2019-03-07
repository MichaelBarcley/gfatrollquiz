import { Component, OnInit } from '@angular/core';
import { RegisterService } from 'src/app/services/register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";

  constructor(private registerService: RegisterService, private route: Router) { }

  ngOnInit() {
  }

  OnSubmit(username: string, email: string) {
   this.registerService.saveUser(username,email).subscribe(
    (data : any) =>{
      localStorage.setItem('user', JSON.stringify(data));
      this.route.navigate(['/game]']);
    }
   )
  }

}
