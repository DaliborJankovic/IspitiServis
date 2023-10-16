package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.ExamRegistrationRepository;
import DaliborJankovic.StudentskiServis.entity.exams.ExamRegistration;
import DaliborJankovic.StudentskiServis.service.ExamRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ExamRegistration findById(Integer id) {
        Optional<ExamRegistration> result = examRegistrationRepository.findById(id);
        ExamRegistration tempExamReg = null;
        if (result.isPresent()){
            tempExamReg = result.get();
        }
        else {
            throw new RuntimeException("No results");
        }
        return tempExamReg;
    }

    @Override
    public List<ExamRegistration> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
