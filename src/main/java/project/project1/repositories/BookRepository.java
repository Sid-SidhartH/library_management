package project.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project1.models.Book;
import project.project1.models.Genre;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByAuthor_Name(String authorName);

    List<Book> findByName(String name);

    List<Book> findByGenre(Genre genre);
}
