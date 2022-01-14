import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentListComponent} from "./student-list/student-list.component";
import {StudentFormComponent} from "./student-form/student-form.component";

const routes: Routes = [
  {path: "", pathMatch: "full", redirectTo: "student"},
  {path: "student", component: StudentListComponent},
  {path: "student/:id", component: StudentFormComponent},
  {path: "student/new", component: StudentFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
