package Composition.CourseService;

import java.util.ArrayList;

public class Student {
	private String name;
	private String id;

	// to store student's enrolled courses
	private ArrayList<Course> enrolledCourses;

	public Student(String name, String id) {
		this.name = name;
		this.id = id;

		//create an empty enrolledCourses list
		this.enrolledCourses = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// enroll method
	public void enroll(Course course) {
		// add course to enrolledCourse list
		this.enrolledCourses.add(course);
	}

	public void unEnroll(Course course) {
		// remove the course from enrolledCourse list
		this.enrolledCourses.remove(course);
	}

	public int totalEnrollmentCourses() {
		// return total no. of enrolledCourses of student
		return this.enrolledCourses.size();
	}

	public ArrayList<Course> getEnrolledCourses() {
		// return list of enrolled courses of student
		return this.enrolledCourses;
	}

	public String toString() {
		return String.format("Student Id: %s, Name: %s, Enrolled Courses: ", this.id, this.name) + this.enrolledCourses;
	}
}
