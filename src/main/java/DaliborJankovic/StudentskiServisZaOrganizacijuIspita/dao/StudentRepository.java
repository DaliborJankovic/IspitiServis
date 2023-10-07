package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
