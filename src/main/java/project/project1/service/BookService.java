package project.project1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.project1.models.Author;
import project.project1.models.Book;
import project.project1.models.Genre;
import project.project1.repositories.AuthorRepository;
import project.project1.repositories.BookRepository;
import project.project1.request.BookCreateRequest;
import project.project1.request.BookFilterType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public Book createOrUpdate(BookCreateRequest bookCreateRequest){
        Book book = bookCreateRequest.to();
        createOrUpdate(book);
        return book;
    }

    public void createOrUpdate(Book book){
        Author author = book.getAuthor();

        // Find if the author with the given email exists in db or not ??
        // If exists, then don't save, else save it in the db first
        Author authorFromDB = authorRepository.findByEmail(author.getEmail());

        if(authorFromDB == null){
            authorFromDB = authorRepository.save(author);
        }

        // select * from author where email = ?

//        author.setId(1);
//        book.setAuthor(author);  // Not required

        book.setAuthor(authorFromDB);
        bookRepository.save(book);
    }

    public List<Book> find(BookFilterType bookFilterType, String value){

        switch (bookFilterType){
            case NAME:
                return bookRepository.findByName(value);
            case AUTHOR_NAME:
                return bookRepository.findByAuthor_Name(value);
            case GENRE:
                return bookRepository.findByGenre(Genre.valueOf(value));
            case BOOK_ID:
                return bookRepository
                        .findAllById(Collections.singletonList(Integer.parseInt(value)));
            default:
                return new ArrayList<>();
        }
    }
}
