package edu.miu.cse.midtermdemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name = "course_Id")
    private Integer courseId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentName")
    private Department department;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name ="courses_professors",
            joinColumns = @JoinColumn(name ="course_Id"),
            inverseJoinColumns = @JoinColumn(name="professor_Id")
    )
    private List<Professor> listProfessor;
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                '}';
    }
}
