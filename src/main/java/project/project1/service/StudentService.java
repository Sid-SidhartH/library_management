package project.project1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.project1.models.Student;
import project.project1.repositories.StudentRepository;
import project.project1.request.BookCreateRequest;
import project.project1.request.StudentCreateRequest;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student create(StudentCreateRequest studentCreateRequest) {

        Student student=studentCreateRequest.to();
        studentRepository.save(student);

        return student;
    }

    public Student findStudentByStudentId(int sId){
        return studentRepository
                .findById(sId).orElse(null);
    }
}
