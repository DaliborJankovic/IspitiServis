package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.entity.exams.ExamRegistration;
import DaliborJankovic.StudentskiServis.entity.users.Student;

import java.util.List;

public interface ExamRegistrationService {

    void save(ExamRegistration examRegistration);

    ExamRegistration findById(Long id);

    List<ExamRegistration> findAll();

    void deleteById(Long id);

    List<String> dateValidation(ExamPeriod examPeriod);

    List<String> examValidation(Student student, Exam exam);

    List<ExamRegistration> findAllExamsRegistrationsInExam(Exam exam);

}
