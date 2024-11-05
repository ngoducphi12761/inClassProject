package edu.miu.cse.midtermdemo.repository;

import edu.miu.cse.midtermdemo.model.Course;
import edu.miu.cse.midtermdemo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    public Optional <Course> findByCourseName(String courseName);
    @Query("SELECT p FROM Course p WHERE p.department = :department order by p.courseName ASC")
    List<Course> findCourseUsingDepartmentName(@Param("department") Department department);


}
