package edu.miu.cse.midtermdemo.service;

import edu.miu.cse.midtermdemo.model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfessorService {
    Optional<Professor> addNewProfessor(Professor professor);
    Optional<Professor> findProfessorByFirstNameAndLastname(String firstName, String lastName);
    List<Professor> sortByLastname();
}
