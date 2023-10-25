package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.SubjectRepository;
import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import DaliborJankovic.StudentskiServis.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    @Transactional
    public void save(Subject theSubject) {
        subjectRepository.save(theSubject);
    }

    @Override
    public Subject findById(Long id) {
        Optional<Subject> result = subjectRepository.findById(id);
        Subject tempSubject = null;

        if (result.isPresent()) {
            tempSubject = result.get();
        }
        else {
            throw new RuntimeException("There is no subject with id - " + id);
        }

        return tempSubject;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }
}
