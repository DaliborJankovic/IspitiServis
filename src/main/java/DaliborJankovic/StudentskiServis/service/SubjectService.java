package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;

import java.util.List;

public interface SubjectService {

    void save(Subject theSubject);

    Subject findById (Long id);

    List<Subject> findAll();

    void deleteById(Long id);

}
