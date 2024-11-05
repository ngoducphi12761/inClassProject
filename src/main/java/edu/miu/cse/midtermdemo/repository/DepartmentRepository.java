package edu.miu.cse.midtermdemo.repository;

import edu.miu.cse.midtermdemo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public Optional<Department> findByDepartmentName(String name);
    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.courses c ORDER BY d.departmentName, c.courseName")
    List<Department> findAllDepartmentsGroupedByDepartmentName();
}
