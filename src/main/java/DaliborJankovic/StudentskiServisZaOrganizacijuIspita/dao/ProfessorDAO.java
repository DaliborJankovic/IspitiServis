package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Professor;

import java.util.List;

public interface ProfessorDAO {

    void save(Professor theProfessor);

    Professor findById (Integer id);

    List<Professor> findByAll ();

    void update(Professor theProfessor);

    void delete(Integer id);

}
