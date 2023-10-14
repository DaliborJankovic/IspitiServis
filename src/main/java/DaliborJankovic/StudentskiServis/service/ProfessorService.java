package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.users.Professor;

import java.util.List;

public interface ProfessorService {

    void save(Professor theProfessor);

    Professor findById (Integer id);

    List<Professor> findAll();

    void deleteById(Integer id);

}
