package project.project1.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name="land")
    private String country;
    private int age;

    @Column(unique = true,nullable = false)
    private String email;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private List<Book> bookList;

    @CreationTimestamp
    private Date addedOn;
}
