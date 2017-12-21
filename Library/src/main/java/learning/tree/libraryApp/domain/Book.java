package learning.tree.libraryApp.domain;

public class Book {
    String  name;
    String  author;
    String  ISBN;
    Student borrowingStudent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Student getBorrowingStudent() {
        return borrowingStudent;
    }

    public void setBorrowingStudent(Student borrowingStudent) {
        this.borrowingStudent = borrowingStudent;
    }

    public Book(String ISBN, String name, String author) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.borrowingStudent = null;
    }

    public String toString() {
        String description = "Name = " + name + " ISBN = " + ISBN + " Author = " + author;
        if (borrowingStudent == null) {
            return description;
        } else {
            return description + " BorrowingStudent = " + borrowingStudent.toString();
        }
    }
}
