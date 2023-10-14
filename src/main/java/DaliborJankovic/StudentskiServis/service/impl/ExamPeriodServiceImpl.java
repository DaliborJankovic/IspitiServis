package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.ExamPeriodRepository;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.service.ExamPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamPeriodServiceImpl implements ExamPeriodService {

    private ExamPeriodRepository examPeriodRepository;

    @Autowired
    public ExamPeriodServiceImpl(ExamPeriodRepository examPeriodRepository) {
        this.examPeriodRepository = examPeriodRepository;
    }

    @Override
    public void save(ExamPeriod examPeriod) {
        examPeriodRepository.save(examPeriod);
    }

    @Override
    public ExamPeriod findById(Integer id) {
        Optional<ExamPeriod> result = examPeriodRepository.findById(id);
        ExamPeriod tempExamPeriod = null;
        if (result.isPresent()){
            tempExamPeriod = result.get();
        }
        else {
            throw new RuntimeException("No results for Exam Period");
        }

        return tempExamPeriod;
    }

    @Override
    public List<ExamPeriod> findAll() {
        return examPeriodRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        examPeriodRepository.deleteById(id);
    }
}
