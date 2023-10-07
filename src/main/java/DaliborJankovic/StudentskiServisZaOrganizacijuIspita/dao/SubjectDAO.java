package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Subject;

import java.util.List;

public interface SubjectDAO {

    void save(Subject theSubject);

    Subject findById (Integer id);

    List<Subject> findAll();

    void update(Subject theSubject);

    void delete(Integer id);

}
