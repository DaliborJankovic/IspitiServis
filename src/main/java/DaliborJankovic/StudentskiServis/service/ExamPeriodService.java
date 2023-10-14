package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;

import java.util.List;

public interface ExamPeriodService {

    void save(ExamPeriod examPeriod);

    ExamPeriod findById (Integer id);

    List<ExamPeriod> findAll();

    void deleteById(Integer id);

}
