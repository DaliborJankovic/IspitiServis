package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
