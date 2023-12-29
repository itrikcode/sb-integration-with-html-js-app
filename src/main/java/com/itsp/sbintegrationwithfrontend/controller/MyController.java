package com.itsp.sbintegrationwithfrontend.controller;

import com.itsp.sbintegrationwithfrontend.dao.StudentRepo;
import com.itsp.sbintegrationwithfrontend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {


    @Autowired
    StudentRepo studentRepo;
//    @CrossOrigin
//    @GetMapping("/api/data")
//    public String fetchData() {
//        // Implement your logic to fetch data
//        return "Test Data is hello and bye";
//    }

    @CrossOrigin
    @PostMapping("/api/save")
    public String saveData(@RequestBody Student student) {
        // Implement your logic to fetch data
        return studentRepo.saveStudent(student);
    }

    @CrossOrigin
    @GetMapping("/api/data")
    public List<Student> getData() {
        // Implement your logic to fetch data
        return studentRepo.showStudent();
    }

    @CrossOrigin
    @DeleteMapping("/api/delete/{name}")
    public String deleteData(@PathVariable String name){
        return studentRepo.deleteStudent(name);
    }
}
