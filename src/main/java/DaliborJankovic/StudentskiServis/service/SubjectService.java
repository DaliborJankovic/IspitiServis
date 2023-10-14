package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;

import java.util.List;

public interface SubjectService {

    void save(Subject theSubject);

    Subject findById (Integer id);

    List<Subject> findAll();

    void deleteById(Integer id);

}
