package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
