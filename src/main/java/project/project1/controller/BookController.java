package project.project1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import project.project1.models.Book;
import project.project1.request.BookCreateRequest;
import project.project1.request.BookFilterType;
import project.project1.response.BookSearchResponse;
import project.project1.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

//    @Value("${custom.my_prop}")
//    String sample_text;
//
//    @GetMapping("/sample")
//    public String getSampleText(){
//        return this.sample_text;
//    }
    @Autowired
    BookService bookService;


    @PostMapping("/book")
    public Book createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
        return bookService.createOrUpdate(bookCreateRequest);
    }

    @GetMapping("/books/search")
    public List<BookSearchResponse> findBooks(
            @RequestParam("filter") BookFilterType bookFilterType,
            @RequestParam("value") String value){

        return bookService
                .find(bookFilterType, value)
                .stream()
                .map(book -> book.to())
                .collect(Collectors.toList());
    }
}
