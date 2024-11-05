package edu.miu.cse.midtermdemo.repository;

import edu.miu.cse.midtermdemo.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
   public Optional<Professor> findByFirstNameAndLastName(String firstName, String lastName);
   public Optional<Professor> findByLastName(String lastName);
   @Query("SELECT p FROM Professor p ORDER BY p.lastName ASC,p.firstName DESC")
   List<Professor> sortByLastName();
}
