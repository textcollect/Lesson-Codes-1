package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap

    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id
        return null;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if not enroll student to the course

    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses

    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses

        return null;
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id

        return null;
    }

}
