package Composition.CourseService;

import java.util.HashMap;

// CourseService, which is a composite class, 'Has' Course & Student class
// +: public; #: protected; -: private
public class CourseService {
	private HashMap<String, Student> students;
	private HashMap<String, Course> courses;

	public CourseService() {
		// Create 3 course instance objects
		Course courseJava = new Course("Introduction to Java", "java1", 5);
		Course courseCSS = new Course("Introduction to CSS", "css1", 3);
		Course courseHTML = new Course("Introduction to HTML", "html1", 3);

		// 2 student instances
		Student student1 = new Student("Jean Looi", "111");
		Student student2 = new Student("Brian Chew", "222");

		this.courses = new HashMap<>();
		this.students = new HashMap<>();

		// key=id, value=Course/Student
		this.courses.put(courseJava.getId(), courseJava);
		this.courses.put(courseCSS.getId(), courseCSS);
		this.courses.put(courseHTML.getId(), courseHTML);

		this.students.put(student1.getId(), student1);
		this.students.put(student2.getId(), student2);
	}

	public void addCourse(String name,String id, int credit) {
		//TODO - To add new courses to the courses HashMap
		// Create new Course object to add to HashMap
		Course course = new Course(name, id, credit);
		this.courses.put(course.getId(), course);
	}

	public HashMap<String, Course> getCourse() {
		return this.courses;
	}

	public Course findCourse(String id) {
		//TODO - To be able to return a Course with the courseid passed in as the parameter
		// Check if id exist in courses hashmap
		// return `this.courses.get(id)` if exist, else return null
		if (this.courses.containsKey(id)) {
			return this.courses.get(id); //returns a `Course` object
		}
		return null;
	}

	public void addStudent(String id, String name) {
		Student student = new Student(name, id);
		this.students.put(id, student);
	}

	public void enrollCourseToStudent(String studentId, String courseId) {
		//TODO To enroll student to the course with the studentId and courseId passed
		// in as the parameters

		//Student student = new Student("", studentId);
		//this.students.get(studentId); //returns Student object

		// the next line means to use the Student object returned from `this.students.get(studentId)`
		//as the entry into the Student class to access the `enroll(Course course)` method to enroll the student into the course
		// Reference to the above method where `findCourse(String id)` returns a Course object

		this.students.get(studentId).enroll(findCourse(courseId));

		/*
		if (this.students.containsKey(studentId)) {
			this.students.get(studentId).enroll(findCourse(courseId));
		}

		Student getStudent = this.student.get(studentId);
		Course getCourse = findCourse(courseId);
		getStudent.enroll(getCourse);
		 */
	}

	public void unEnrollCourseToStudent(String studentId, String courseId) {
		//TODO To unenroll student from the course with the studentId and courseId passed in as the parameters
		// look into explanation in `enrollStudent` method above for explanation of the line below
		this.students.get(studentId).unEnroll(findCourse(courseId));
	}

	public Student displayStudentInformation(String studentId) {
		//TODO - Return the student information (object) with the studentID passed in
		// as the parameter
		return this.students.get(studentId);
	}

	public int totalEnrolledCourses(String studentId) {
		//TODO - return the number of enrolled Courses of the student from the studentId
		// NOTE: Reference to explanation in `enrollStudent` method above to understand the code below
		return this.students.get(studentId).totalEnrollmentCourses();
	}

	public int totalCredit(String studentId)
	{
		//TODO - return the total number of credit(s) of the student from the studentId
		int totalCredit = 0;

		// for-each element in `this.students.get(studentId).getEnrolledCourses()` ArrayList (which is of the `Course` datatype)
		// assign them to the variable `credit`
		for (Course credit : this.students.get(studentId).getEnrolledCourses()) {
			totalCredit += credit.getCredits();
		}
		return totalCredit;
	}

	public String toString() {
		String courseTitle = "Courses offered from Jean's Learning Centre: \n";
		String studentTitle = "Students registered to Jean's Learning Centre: \n";

		String printCourses = "";
		String printStudents = "";

		// for-each element in the `courses` ArrayList, assign to variable `c` of `Course` datatype
		for (Course c : this.courses.values()) {
			printCourses += c + "\n";
		}

		for (Student s : this.students.values()) {
			printStudents += s + "\n";
		}

		return courseTitle + printCourses +"\n"+ studentTitle + printStudents;
	}
}
