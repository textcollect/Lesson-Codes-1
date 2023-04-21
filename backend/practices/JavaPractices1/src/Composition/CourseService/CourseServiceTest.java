package Composition.CourseService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CourseServiceTest {
	private CourseService courseService = new CourseService();

	@Test
	@DisplayName("Test addCourse and findCourse methods")
	void addCourseFindCourse() {
		String courseID = "newCourseID"; // new courseID to be added to course HashMap
		courseService.addCourse("New Course", courseID, 3);

		// Get new course added to HashMap
		courseService.getCourse().get(courseID); //getCourse method

		// Retrieve newly added course
		courseService.findCourse(courseID); //findCourse method

		// if all 3 methods are correct, `getCourse()` method should give the same result as `findCourse`
		assertEquals(courseService.getCourse().get(courseID), courseService.findCourse(courseID));
	}

	@Test
	void getCourse() {
	}

	@Test
	void findCourse() {
	}

	@Test
	void addStudent() {
	}

	@Test
	void enrollCourseToStudent() {
	}

	@Test
	void unEnrollCourseToStudent() {
	}

	@Test
	void displayStudentInformation() {
	}

	@Test
	void totalEnrolledCourses() {
	}

	@Test
	void totalCredit() {
	}

	@Test
	void testToString() {
	}

}
