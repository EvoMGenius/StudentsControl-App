import { Component, OnInit } from '@angular/core';
import {StudentService} from "../service/student.service";
import {Student} from "../service/student";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.less']
})
export class StudentListComponent implements OnInit {

  public students: Student[] = [];
  public isError: boolean = false;

  constructor(public studentService: StudentService) { }

  ngOnInit(): void {
    this.retrieveAllStudents();
  }

  private retrieveAllStudents() {
    this.studentService.findAll()
      .then(res=>{
        this.students = res;
        this.isError = false;
      }).catch(err =>{
        console.log(err);
        this.isError = true;
    })
  }

  delete(id: number) {
    this.studentService.delete(id)
      .then(()=>{
      this.retrieveAllStudents();
    }).catch(err =>{
      console.log(err);
    });
  }
}
