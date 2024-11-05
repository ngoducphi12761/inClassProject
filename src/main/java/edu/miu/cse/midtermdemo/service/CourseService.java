package edu.miu.cse.midtermdemo.service;

import edu.miu.cse.midtermdemo.model.Course;
import edu.miu.cse.midtermdemo.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    public Optional<Course> addCourse(Course course);
    public Optional<Course> findCourseByName(String courseName);
    public void deleteCourse(Course course);
    List<Course> findAllCoursesSortedByName(Department department);
}
