package com.apatios.springbootapp.controllers;

import com.apatios.springbootapp.entities.Student;
import com.apatios.springbootapp.exceptions.InvalidAttributeValueException;
import com.apatios.springbootapp.exceptions.ResourceNotFoundException;
import com.apatios.springbootapp.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
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
        return service.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student not found, id: "+id));
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        if(student.getId()!=null){
            throw new InvalidAttributeValueException(String.format("ID of this student %s must be null", student));
        }
        return service.save(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student){
        if(student.getId()==null){
            throw new InvalidAttributeValueException(String.format("ID of this student %s mustn't be null", student));
        }
        return service.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

}
