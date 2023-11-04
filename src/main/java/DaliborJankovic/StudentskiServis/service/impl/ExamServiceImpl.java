package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.ExamRepository;
import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.entity.exams.ExamRegistration;
import DaliborJankovic.StudentskiServis.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Exam findById(Long id) {
        Optional<Exam> result = examRepository.findById(id);
        Exam tempExam = null;
        if (result.isPresent()) {
            tempExam = result.get();
        } else {
            throw new RuntimeException("No results");
        }
        return tempExam;
    }

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        examRepository.deleteById(id);
    }

    @Override
    public List<String> validateExam(Exam theExam) {
        List<String> errorMessages = new ArrayList<>();
        if (theExam.getDateOfExam().isBefore(theExam.getExamPeriod().getStartDate()) ||
                theExam.getDateOfExam().isAfter(theExam.getExamPeriod().getEndDate())) {
            errorMessages.add("The selected exam date is out of the exam deadline date range.");
        }
        List<Exam> exams = findAllExamsInExamPeriod(theExam.getExamPeriod());
        for (Exam exam : exams) {
            if (exam.getSubject().equals(theExam.getSubject())) {
                errorMessages.add("Exam is already registered for selected exam period.");
            }
        }
        return errorMessages;
    }

    @Override
    public List<Exam> findAllExamsInExamPeriod(ExamPeriod examPeriod) {
        return examRepository.findAllExamsInExamPeriod(examPeriod);
    }

}
