package learning.tree.operations;

import learning.tree.libraryApp.domain.Library;
import learning.tree.libraryApp.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class StudentWalkOut {
    Logger logger = LoggerFactory.getLogger(StudentWalkOut.class);
    Library      library;
    Set<Student> studentsToCheckOut;

    public class WalkIn implements Runnable {
        @Override
        public void run() {
            for (Student student : studentsToCheckOut) {
                studentsToCheckOut.remove(student);
                library.checkOutStudent(student);
                return;
            }
        }
    }

    public void addStudent(Student student) {
        if (!studentsToCheckOut.contains(student)) {
            this.studentsToCheckOut.add(student);
        } else {
            logger.error("Trying to checkIn student twice!! " + student.toString());
        }
    }

    public StudentWalkOut(Library library) {
        this.library = library;
    }
}