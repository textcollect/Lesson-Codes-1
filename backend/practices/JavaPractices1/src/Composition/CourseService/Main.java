package Composition.CourseService;

public class Main {
	public static void main(String[] args) {
		CourseService courseService = new CourseService();
		System.out.println(courseService);

//		courseService.enrollCourseToStudent("111", "java1");
//		courseService.enrollCourseToStudent("111", "html1");
//
//		System.out.println(courseService);
//		System.out.println(courseService.totalCredit("111"));

		// testing findCourse method in CourseService
		if (courseService.findCourse("css1") != null) {
			System.out.println("Course found!");
		} else {
			System.out.println("Course not found!");
		}
	}
}
