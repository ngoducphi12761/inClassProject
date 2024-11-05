package edu.miu.cse.midtermdemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "professor_Id")
    private Integer professorId;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "listProfessor")
    List<Course>courseList;
    private String firstName;
    private String lastName;

    public Professor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    @Override
    public String toString() {
        return "Professor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
