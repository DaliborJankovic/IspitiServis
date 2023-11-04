package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import org.springframework.ui.Model;

import java.util.List;

public interface ExamPeriodService {

    void save(ExamPeriod examPeriod);

    ExamPeriod findById(Integer id);

    List<ExamPeriod> findAll();

    void deleteById(Integer id);

    void isActive(List<ExamPeriod> examPeriodList, Model theModel);

    List<String> validateExamPeriod(List<ExamPeriod> examPeriodList, ExamPeriod currentExamPeriod);


}
