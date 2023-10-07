package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Professor;

import java.util.List;

public interface ProfessorService {

    void save(Professor theProfessor);

    Professor findById (Integer id);

    List<Professor> findAll();

    void deleteById(Integer id);

}
