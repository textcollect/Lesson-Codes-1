package com.generation.model;

import com.generation.service.CourseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course )
    {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        if (this.enrolledCourses.containsKey(course.getCode())) {
            // if student has already enrolled to the course, return false -> already enrolled, cannot enroll again
            return false;
        } else {
            // if student has already enrolled to the course, add to enrolledCourses and return true -> can enroll
            this.enrolledCourses.put(course.getCode(), new EnrolledCourse(course));
            return true;
        }
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO return a Hashmap of all the enrolledCourses
        return this.enrolledCourses;
    }

    public void gradeCourse( String courseCode, double grade )
    {
        //TODO set the grade for the enrolled Course
        if (grade < 1 || grade > 6) {
            System.out.println("Invalid grade entered. Try again.");
        } else {
            this.enrolledCourses.get(courseCode).setGrade(grade);
        }
    }

    public Course findCourseById( String courseId )
    {
        //TODO return a Course from the course Id
        //return new CourseService().getCourse(courseId);
        //TODO return the enrolled course with the course Id
        return this.enrolledCourses.get(courseId);
    }

    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //TODO Check the enrolled courses grade and compare to the passing grade
        HashMap<String, EnrolledCourse> passCourse = new HashMap<>();
        for (EnrolledCourse enrolledCourse : this.enrolledCourses.values()) {
            if (enrolledCourse.getGrade() <= 3 && enrolledCourse.getGrade() >=1) {
                passCourse.put(enrolledCourse.getCode(), enrolledCourse);
            }
        }
        return passCourse;
    }

    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
