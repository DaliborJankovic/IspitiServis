package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.users.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
}
