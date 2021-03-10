package com.example.studentSpring;

import com.example.studentSpring.student.Student;
import com.example.studentSpring.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API LAYER talks to SERVICE LAYER
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    //reference to the service class
    private final StudentService studentService;

    //constructor
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentid}")
    public void deleteStudent(@PathVariable("studentid") long studentid){
            studentService.deleteStudent(studentid);
    }

    @PutMapping(path = "{studentid}")
    public void updateStudent(
            @PathVariable("studentid") long studentid,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
            studentService.updateStudent(studentid,name,email);
    }
}