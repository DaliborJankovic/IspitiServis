package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import DaliborJankovic.StudentskiServis.entity.users.Professor;

import java.util.List;

public interface SubjectService {

    void save(Subject theSubject);

    Subject findById (Long id);

    List<Subject> findAll();

    void deleteById(Long id);

    public void addProfessorToSubject(String professorId, Long subjectId);

    void deleteProfessorFromSubject(String professorId, Long subjectId);

}
