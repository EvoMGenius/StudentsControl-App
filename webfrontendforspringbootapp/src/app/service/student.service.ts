import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Student} from "./student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(public http: HttpClient) { }

  public findAll() {
    return this.http.get<Student[]>("api/v1/students").toPromise();
  }

  public findById(id: number) {
    return this.http.get<Student>(`api/v1/students/${id}`).toPromise();
  }

  public save(student:Student){
    if(student.id == -1){
      student.id=NaN;
      return this.http.post(`api/v1/students`,student).toPromise();
    }else{
      return this.http.put(`api/v1/students`,student).toPromise()
    }
  }

  public delete(id: number){
    return this.http.delete(`api/v1/students/${id}`).toPromise()
  }
}
