package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.ExamRegistrationRepository;
import DaliborJankovic.StudentskiServis.entity.exams.Exam;
import DaliborJankovic.StudentskiServis.entity.exams.ExamPeriod;
import DaliborJankovic.StudentskiServis.entity.exams.ExamRegistration;
import DaliborJankovic.StudentskiServis.entity.users.Student;
import DaliborJankovic.StudentskiServis.service.ExamRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamRegistrationServiceImpl implements ExamRegistrationService {

    private ExamRegistrationRepository examRegistrationRepository;

    @Autowired
    public ExamRegistrationServiceImpl(ExamRegistrationRepository examRegistrationRepository) {
        this.examRegistrationRepository = examRegistrationRepository;
    }

    @Override
    public void save(ExamRegistration examRegistration) {
        examRegistrationRepository.save(examRegistration);
    }

    @Override
    public ExamRegistration findById(Long id) {
        Optional<ExamRegistration> result = examRegistrationRepository.findById(id);
        ExamRegistration tempExamReg = null;
        if (result.isPresent()) {
            tempExamReg = result.get();
        } else {
            throw new RuntimeException("No results");
        }
        return tempExamReg;
    }

    @Override
    public List<ExamRegistration> findAll() {
        return examRegistrationRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        examRegistrationRepository.deleteById(id);
    }

    @Override
    public List<String> dateValidation(ExamPeriod examPeriod) {
        List<String> errorMessages = new ArrayList<>();
        LocalDate weekBefore = examPeriod.getStartDate().minus(7, ChronoUnit.DAYS);
        LocalDate today = LocalDate.now();
        if (today.isBefore(weekBefore) ||
                today.isEqual(examPeriod.getStartDate()) ||
                today.isAfter(examPeriod.getStartDate())) {
            errorMessages.add("Exam registration is only available during the one-week period " +
                    "leading up to the exam period.");
        }
        return errorMessages;
    }

    @Override
    public List<String> examValidation(Student student, Exam exam) {
        List<String> errorMessages = new ArrayList<>();
        if (exam.getSubject().getYearOfStudy() > student.getCurrentYearOfStudy()) {
            errorMessages.add("Only students who have attended the subject are eligible for exam registration. " +
                    "Please make sure the student has fulfilled the prerequisite attendance requirements " +
                    "before proceeding with registration.");
        }
//        if (student){
//            errorMessages.add("The selected student has already successfully passed the exam for the chosen subject. " +
//                    "Please review the student's academic record to avoid duplicate registration for this exam.");
//        }
        return errorMessages;
    }

    @Override
    public List<ExamRegistration> findAllExamsRegistrationsInExam(Exam exam) {
        return examRegistrationRepository.findAllExamsRegistrationsInExam(exam);
    }
}
