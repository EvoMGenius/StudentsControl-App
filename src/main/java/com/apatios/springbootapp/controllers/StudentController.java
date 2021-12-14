package com.apatios.springbootapp.controllers;

import com.apatios.springbootapp.entities.Student;
import com.apatios.springbootapp.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Student findById(@PathVariable Long id){
        return service.findById(id).get();
    }

    @PostMapping
    public Student save(@RequestBody Student student){
            return service.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

}
