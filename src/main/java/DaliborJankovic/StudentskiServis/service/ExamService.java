package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;

import java.util.List;

public interface ExamService {

    void save(Exam exam);

    Exam findById(Long id);

    List<Exam> findAll();

    void deleteById(Long id);

    List<String> validateExam(Exam theExam);

    List<Exam> findAllExamsInExamPeriod(ExamPeriod examPeriod);

}
