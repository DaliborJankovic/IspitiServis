package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
