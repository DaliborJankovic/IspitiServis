package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.users.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
