package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    @Query("SELECT e FROM Exam e WHERE e.examPeriod = :examPeriod")
    List<Exam> findAllExamsInExamPeriod(@Param("examPeriod") ExamPeriod examPeriod);
}
