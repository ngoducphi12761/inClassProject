package edu.miu.cse.midtermdemo.service;

import edu.miu.cse.midtermdemo.model.Department;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
    Optional<Department> addNewDepartment(Department department);
    Optional<Department> findByDepartmentName(String departmentName);
    public List<Department> getDepartmentsGroupedAndSorted() ;
}
