package Composition.CourseService;

public class Main {
	public static void main(String[] args) {
		CourseService courseService = new CourseService();
		System.out.println(courseService);

		courseService.enrollStudent("111", "java1");
		courseService.enrollStudent("111", "html1");
		
		System.out.println(courseService);
		System.out.println(courseService.totalCredit("111"));
	}
}
