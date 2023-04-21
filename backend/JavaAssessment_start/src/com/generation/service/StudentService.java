package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;

public class StudentService
{
    // HashMap of all registered students. key=String, value=Student datatype
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap
        this.students.put(student.getId(), student);
    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id
        return this.students.get(studentId);
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if not enroll student to the course
        //TODO check if students hashmap contains the studentsId, if have add the course to the student enrolledCourse
        if (this.students.containsKey(studentId)) {
            //this.students.get(studentId); //returns Student object
            this.students.get(studentId).enrollToCourse(course);
        }
    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
        //this.students.values(); //returns `Students` object

        for (Student student : this.students.values()) {
            System.out.println(student + "\nEnrolled Courses: ");
            for (EnrolledCourse e : student.getEnrolledCourses().values()) {
                System.out.println(e);
            }
        }
    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses
        return this.students.get(student.getId()).getEnrolledCourses();
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id
        //this.enrolledCourses(student); // returns HashMap of EnrolledCourses of the student
        return this.enrolledCourses(student).get(courseId);
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
