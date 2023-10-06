package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById (Integer id);

    List<Student> findByAll ();

    void update(Student theStudent);

    void delete(Integer id);

}
