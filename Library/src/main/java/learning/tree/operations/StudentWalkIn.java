package learning.tree.operations;

import learning.tree.libraryApp.domain.Library;
import learning.tree.libraryApp.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class StudentWalkIn {
    Logger logger = LoggerFactory.getLogger(StudentWalkIn.class);
    Library      library;
    Set<Student> studentsToCheckIn;

    public class WalkIn implements Runnable {
        @Override
        public void run() {
            for (Student student : studentsToCheckIn) {
                studentsToCheckIn.remove(student);
                library.checkInStudent(student);
                return;
            }
        }
    }

    public void addStudent(Student student) {
        if (!studentsToCheckIn.contains(student)) {
            this.studentsToCheckIn.add(student);
        } else {
            logger.error("Trying to checkIn student twice!! " + student.toString());
        }
    }

    public StudentWalkIn(Library library) {
        this.library = library;
    }
}
