package project.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.project1.models.Student;
import project.project1.request.BookCreateRequest;
import project.project1.request.StudentCreateRequest;
import project.project1.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public Student createStudent(@RequestBody StudentCreateRequest studentCreateRequest){

        return studentService.create(studentCreateRequest);
    }

}
