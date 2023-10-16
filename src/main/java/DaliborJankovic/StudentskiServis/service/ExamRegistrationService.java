package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.exams.ExamRegistration;

import java.util.List;

public interface ExamRegistrationService {

    void save(ExamRegistration examRegistration);

    ExamRegistration findById (Integer id);

    List<ExamRegistration> findAll();

    void deleteById(Integer id);

}
