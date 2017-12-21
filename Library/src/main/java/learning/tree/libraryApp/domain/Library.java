package learning.tree.libraryApp.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class Library {
    Logger logger = LoggerFactory.getLogger(Library.class);
    Set<Student> checkedInStudents;
    List<Book>   available;
    List<Book>   onLoan;

    public Set<Student> getCheckedInStudents() {
        return checkedInStudents;
    }

    public void setCheckedInStudents(Set<Student> checkedInStudents) {
        this.checkedInStudents = checkedInStudents;
    }

    public List<Book> getAvailable() {
        return available;
    }

    public void setAvailable(List<Book> available) {
        this.available = available;
    }

    public List<Book> getOnLoan() {
        return onLoan;
    }

    public void setOnLoan(List<Book> onLoan) {
        this.onLoan = onLoan;
    }

    public void checkInStudent(Student student) {
        logger.info("Library checking in student - " + student.toString());
        checkedInStudents.add(student);
    }

    public void checkOutStudent(Student student) {
        logger.info("Library checking out student - " + student.toString());
        checkedInStudents.remove(student);
    }

    public void borrowBook(Book book, Student student) {
        if (available.contains(book)) {
            logger.info("Student " + student.toString() + " has borrowed the book " + book.toString());
            book.setBorrowingStudent(student);
            available.remove(book);
            onLoan.add(book);
        } else {
            logger.error(" Student " + student.toString() + " has requested onLoan book " + book.toString());
        }
    }

    public void returnBook(Book book) {
        if (onLoan.contains(book)) {
            logger.info("Book returned. " + book.toString());
            onLoan.remove(book);
            available.add(book);
        } else {
            logger.error("Returned book was never on loan " + book.toString());
        }
    }
}
