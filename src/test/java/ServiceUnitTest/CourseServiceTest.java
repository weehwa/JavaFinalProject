package ServiceUnitTest;
import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.service.CourseService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseServiceTest {
    // Sample data
    final private CourseService courseService = new CourseService();
    Module module = new Module("testMo", "testModule", "testDes");
    Course newCourse = new Course("testCode", "testCourse", 6, module);

    @Test
    public void testRegisterCourse() {
        // Initiate function to test
        courseService.registerCourse(newCourse);
        // Check result
        assertEquals(newCourse, courseService.getCourse("testCode"));
    }

    @Test
    public void testGetCourse() {
        // register it new course
        courseService.registerCourse(newCourse);
        // Initiate function to test
        Course retrievedCourse = courseService.getCourse("testCode");
        // Check result
        assertEquals(newCourse, retrievedCourse);
    }
}
