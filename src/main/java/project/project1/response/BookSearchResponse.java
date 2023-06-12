package project.project1.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import project.project1.models.Author;
import project.project1.models.Genre;
import project.project1.models.Student;
import project.project1.models.Transaction;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookSearchResponse {

    private int id;
    private String name;
    private int cost;

    private Genre genre;

    @JsonIgnoreProperties({"bookList"})
    private Author author;
    private Student student;

    private List<Transaction> transactionList;
    private Date createdOn;
    private Date updatedOn;
}
