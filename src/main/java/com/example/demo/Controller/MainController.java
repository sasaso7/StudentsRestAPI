package com.example.demo.Controller;


import com.example.demo.Model.Student;
import com.example.demo.Model.Supervisor;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.SupervisorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {

    StudentRepository studentRepository;
    SupervisorRepository supervisorRepository;

    public MainController(StudentRepository studentRepository, SupervisorRepository supervisorRepository){
        this.studentRepository = studentRepository;
        this.supervisorRepository = supervisorRepository;
    }


    @GetMapping("/")
    public String index(Model model){
        Iterable<Student> Studentlist = studentRepository.findAll();
        Iterable<Supervisor> Superviserlist = supervisorRepository.findAll();
        model.addAttribute("studentlist", Studentlist);
        model.addAttribute("supervisorlist", Superviserlist);
        return "index";

    }

}
