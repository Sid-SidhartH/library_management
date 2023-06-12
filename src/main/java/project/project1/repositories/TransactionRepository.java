package project.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project1.models.Book;
import project.project1.models.Student;
import project.project1.models.Transaction;
import project.project1.models.TransactionType;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    Transaction findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(
            Book book, Student student, TransactionType transactionType
    );
}
