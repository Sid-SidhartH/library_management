package project.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project1.models.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
