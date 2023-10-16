package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.exams.Exam;

import java.util.List;

public interface ExamService {

    void save(Exam exam);

    Exam findById (Integer id);

    List<Exam> findAll();

    void deleteById(Integer id);

}
