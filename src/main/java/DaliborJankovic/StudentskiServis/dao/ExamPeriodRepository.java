package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Integer> {
}
