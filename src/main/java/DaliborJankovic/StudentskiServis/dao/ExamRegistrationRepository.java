package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRegistrationRepository extends JpaRepository<ExamRegistration, Long> {
    @Query("SELECT e FROM ExamRegistration e WHERE e.exam = :exam")
    List<ExamRegistration> findAllExamsRegistrationsInExam(@Param("exam") Exam exam);
}
