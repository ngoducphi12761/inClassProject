package edu.miu.cse.midtermdemo.service.impl;

import edu.miu.cse.midtermdemo.model.Professor;
import edu.miu.cse.midtermdemo.repository.ProfessorRepository;
import edu.miu.cse.midtermdemo.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    @Override
    public Optional<Professor> addNewProfessor(Professor professor) {
        return Optional.of(professorRepository.save(professor));
    }

    @Override
    public Optional<Professor> findProfessorByFirstNameAndLastname(String firstName, String lastName) {
        return professorRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Professor> sortByLastname() {
        return professorRepository.sortByLastName();
    }
}
