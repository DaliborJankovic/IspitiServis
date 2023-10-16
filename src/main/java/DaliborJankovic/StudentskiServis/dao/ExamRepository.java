package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
