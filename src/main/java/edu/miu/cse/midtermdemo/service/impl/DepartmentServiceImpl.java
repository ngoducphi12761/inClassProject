package edu.miu.cse.midtermdemo.service.impl;

import edu.miu.cse.midtermdemo.model.Department;
import edu.miu.cse.midtermdemo.repository.DepartmentRepository;
import edu.miu.cse.midtermdemo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Optional<Department> addNewDepartment(Department department) {
        return Optional.of(departmentRepository.save(department));
    }

    @Override
    public Optional<Department> findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public List<Department> getDepartmentsGroupedAndSorted() {
        return departmentRepository.findAllDepartmentsGroupedByDepartmentName();
    }
}
