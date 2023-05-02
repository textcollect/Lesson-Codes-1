package com.generation.model;

import java.util.Date;
import java.util.HashMap;

public class Student extends Person
{
    private double average;
    public static final double PASS_MIN_GRADE = 3.0;

    //HashMap of enrolledCourses of this student
    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course )
    {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        if (this.enrolledCourses.containsKey(course.getCode())) {
            return true;
        } else {
            this.enrolledCourses.put(course.getCode(), new EnrolledCourse(course));
            return false;
        }
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO return a Hashmap of all the enrolledCourses
        return this.enrolledCourses;
    }

    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
