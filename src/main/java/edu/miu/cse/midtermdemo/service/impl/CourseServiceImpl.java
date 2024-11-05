package edu.miu.cse.midtermdemo.service.impl;

import edu.miu.cse.midtermdemo.model.Course;
import edu.miu.cse.midtermdemo.model.Department;
import edu.miu.cse.midtermdemo.repository.CourseRepository;
import edu.miu.cse.midtermdemo.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Optional<Course> addCourse(Course course) {
        return Optional.of(courseRepository.save(course));
    }

    @Override
    public Optional<Course> findCourseByName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    @Override
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    @Override
    public List<Course> findAllCoursesSortedByName(Department department) {
        return courseRepository.findCourseUsingDepartmentName(department);
    }
}
