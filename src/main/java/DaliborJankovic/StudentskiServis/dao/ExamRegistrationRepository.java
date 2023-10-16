package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.exams.ExamRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRegistrationRepository extends JpaRepository<ExamRegistration, Integer> {
}
