package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Model.Supervisor;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.SupervisorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SupervisorRestController {

    SupervisorRepository supervisorRepository;

    public SupervisorRestController(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    // HTTP protokol metode get
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @GetMapping("/supervisor/get")
    public Iterable<Supervisor> index() {
        return supervisorRepository.findAll();
    }

    // Read One
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @GetMapping("/supervisor/get/{id}")
    public ResponseEntity<Optional<Supervisor>> readOne(@PathVariable Long id) {
        Optional<Supervisor> res = supervisorRepository.findById(id);
        if (res.isPresent()) {
            return ResponseEntity.status(200).body(res);
        } else {
            return ResponseEntity.status(404).body(res); // TODO send
        }
    }

    // Post
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping("/supervisor/post")
    public ResponseEntity<String> create(@ModelAttribute Supervisor s) {
        Supervisor supervisor = supervisorRepository.save(s);
        return ResponseEntity.status(201).header("Location", "/post/" + supervisor.getId()).body("{'Msg': 'post created'}");
    }

    // Update
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PutMapping("/supervisor/post")
    public ResponseEntity<String> update(@ModelAttribute Supervisor s) {
        supervisorRepository.save(s);
        return ResponseEntity.status(204).body("{'msg':'Hello'}");
    }

    // Delete
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @DeleteMapping("/supervisor/post/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        supervisorRepository.deleteById(id);
        return ResponseEntity.status(200).body("{'msg':'Deleted'}");
    }

}

