import { Component, OnInit } from '@angular/core';
import {StudentService} from "../service/student.service";
import {Student} from "../service/student";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.less']
})
export class StudentFormComponent implements OnInit {

  public student = new Student(-1, "", 0);
  public isError: boolean = false;

  constructor(public studentService: StudentService,
              public route: ActivatedRoute,
              public router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      if (param.id == "new") {
        this.student = new Student(-1, "",0);
        return;
      }
      this.studentService.findById(param.id)
        .then(res => {
          this.isError = false;
          this.student = res;
        })
        .catch(err => {
          console.log(err);
          this.isError = true;
        })

    });
  }

  save() {
    this.studentService.save(this.student)
      .then(()=>{
        this.isError = false;
        this.router.navigateByUrl('/student');
      }).catch(err =>{
        console.log(err);
        this.isError = true;
    });

  }
}
