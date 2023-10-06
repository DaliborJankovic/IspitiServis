package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao;


import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Student;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Subject;

import java.util.List;

public interface SubjectDAO {

    void save(Subject theSubject);

    Subject findById (Integer id);

    List<Subject> findByAll ();

    void update(Subject theStudent);

    void delete(Integer id);


}
