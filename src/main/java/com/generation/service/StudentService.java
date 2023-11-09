package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private final Map<String, Student> students = new HashMap<>();
    public void subscribeStudent(Student student) {
        students.put(student.getId(), student);
    }
    public Student findStudent(String studentId) {
        if (students.containsKey(studentId)) {
            return students.get(studentId);
        }
        return null;
    }

    public boolean isSubscribed(String studentId) {
        //TODO implement this method
        return students.containsKey(studentId);
    }

    public void showSummary() {
        //TODO implement
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }


    public void enrollToCourse(String studentId, Course course) {
        if (isSubscribed(studentId)) {
            students.get(studentId).enrollToCourse(course);
        }
    }

    public double countAvg(Course course) {
        // declare empty const
        double totalGrade = 0.0;
        int studentCount = 0;
        // Loop through students list and get the value
        for (Student student : students.values()) {
            // Check if the student has passed the course
            List<Course> passedCourses = student.findPassedCourses(course);
            if (passedCourses.contains(course)) {
                double studentGrade = student.getGrade(course.getCode());
                // add grade and and student count
                totalGrade += studentGrade;
                studentCount++;
            }
        }
        //return the average
        return totalGrade / studentCount;
    }
}




