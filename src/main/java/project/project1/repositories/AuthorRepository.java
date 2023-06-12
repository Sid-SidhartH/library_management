package project.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project1.models.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Author findByEmail(String email);
}
