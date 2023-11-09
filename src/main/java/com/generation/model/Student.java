package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
    extends Person
    implements Evaluation
{
    private double average;
    private final List<Course> courses = new ArrayList<>();
    private final Map<String, Course> approvedCourses = new HashMap<>();
    final private Map<String, Double> courseGrades = new HashMap<>();
    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate);
    }

    public void enrollToCourse( Course course )
    {
        //TODO implement this method
        registerApprovedCourse(course);
        courses.add(course);
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )
    {
        //TODO implement this method
        return approvedCourses.containsKey(courseCode);
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses(Course course)
    {
        //TODO implement this method
        //create new empty list
        List<Course> passedCourses = new ArrayList<>();
        // Loop through for each key from courseGrade list
        for (Map.Entry<String, Double> entry : courseGrades.entrySet()) {
            // check if student pass the course
            if (entry.getValue() >= 60.0) {
                //get course key and compare if they are the same in approvedCourses
                Course passedCourse = approvedCourses.get(entry.getKey());
                // if pass course and course exit append to passCourse list
                if (passedCourse != null && passedCourse.equals(course)) {
                    passedCourses.add(passedCourse);
                }
            }
        }
        return passedCourses;
    }

    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method
        // loop to check if course passed in param is in course using id
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        //TODO implement this method
        return new ArrayList<>(approvedCourses.values());
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

    public void setGrade(String courseCode, double grade) {
        courseGrades.put(courseCode, grade);
    }

    public double getGrade(String courseCode) {
        return courseGrades.getOrDefault(courseCode, 0.0);
    }
}
