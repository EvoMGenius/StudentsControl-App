package com.apatios.springbootapp.services;

import com.apatios.springbootapp.entities.Student;
import com.apatios.springbootapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Transactional
    public Optional<Student> findById(long id){
        return studentRepository.findById(id);
    }

    @Transactional
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteById(long id){
        studentRepository.deleteById(id);
    }
    
}
