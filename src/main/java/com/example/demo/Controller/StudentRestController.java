package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.SupervisorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentRestController {

    StudentRepository studentRepository;
    SupervisorRepository supervisorRepository;

    public StudentRestController(StudentRepository studentRepository, SupervisorRepository supervisorRepository){
        this.studentRepository = studentRepository;
        this.supervisorRepository = supervisorRepository;
    }

    // HTTP protokol metode get
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @GetMapping("/student/get")
    public Iterable<Student> index(){
        return studentRepository.findAll();
    }

    // Read One
    @GetMapping("/student/get/{id}")
    public ResponseEntity<Optional<Student>> readOne(@PathVariable Long id){
        Optional<Student> res = studentRepository.findById(id);
        if(res.isPresent()){
            return ResponseEntity.status(200).body(res);
        } else {
            return ResponseEntity.status(404).body(res); // TODO send
        }
    }

    // Post
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping("/student/post")
    public ResponseEntity<String> create(@ModelAttribute Student s){
        s.setSupervisor(supervisorRepository.findById(s.getSupervisor()).get()); //Fuldstændig ulæseligt
        Student student = studentRepository.save(s);
        return ResponseEntity.status(201).header("Location", "/student/" + student.getId()).body("{'Msg': 'student created'}");
    }

    // Update

    @PutMapping("/student/post")
    public ResponseEntity<String> update(@ModelAttribute Student s){
        s.setSupervisor(supervisorRepository.findById(s.getSupervisor()).get());
        studentRepository.save(s);
        return ResponseEntity.status(204).body("{'msg':'Updated'}");
    }

    // Delete

    @DeleteMapping("/student/post/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        studentRepository.deleteById(id);
        return ResponseEntity.status(200).body("{'msg':'Deleted'}");
    }

    
}
