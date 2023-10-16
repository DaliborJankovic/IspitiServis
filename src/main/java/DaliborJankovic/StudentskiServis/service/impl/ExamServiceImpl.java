package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.ExamRepository;
import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.entity.exams.ExamRegistration;
import DaliborJankovic.StudentskiServis.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    private ExamRepository examRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public void save(Exam exam) {
        examRepository.save(exam);
    }

    @Override
    public Exam findById(Integer id) {
        Optional<Exam> result = examRepository.findById(id);
        Exam tempExam = null;
        if (result.isPresent()){
            tempExam = result.get();
        }
        else {
            throw new RuntimeException("No results");
        }

        return tempExam;
    }

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        examRepository.deleteById(id);
    }
}
