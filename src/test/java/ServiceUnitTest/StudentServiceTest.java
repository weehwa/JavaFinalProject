package ServiceUnitTest;
import com.generation.model.Student;
import com.generation.service.StudentService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.time.LocalDate;
import java.util.Date;

public class StudentServiceTest {
    // sample data
    final private StudentService studentService = new StudentService();
    LocalDate date = LocalDate.parse("2010-05-05");
    Date birthday = java.sql.Date.valueOf(date);
    Student newStudent = new Student("1","Tom","tom@jerry.com", birthday);
    Student notSubscrbedStudent = new Student("2","Jerry","jerry@tom.com", birthday);

    @Test
    public void TestFindStudent(){
        // subscribe
        studentService.subscribeStudent(newStudent);
        // Initiate function to test
        Student foundStudent1 = studentService.findStudent(newStudent.getId());
        // Check result
        assertEquals("1", foundStudent1.getId());

        // Test for a non-existing student
        Student foundStudent2 = studentService.findStudent(notSubscrbedStudent.getId());
        assertNull(foundStudent2);
    }

    @Test
    public void testIsSubscribed() {
        // Subscribe the student
        studentService.subscribeStudent(newStudent);
        // Check result
        assertTrue(studentService.isSubscribed(newStudent.getId()));
        // Test for a non-subscribed student
        assertFalse(studentService.isSubscribed(notSubscrbedStudent.getId()));
    }
}

