package edu.miu.cse.midtermdemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer departmentId;
    private String departmentName;
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
    @OneToMany(mappedBy = "department")
    private List<Professor> professors;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "department")
    private List<Course> courses;
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
