package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Student;

import java.util.List;

public interface StudentService {

    void save(Student theStudent);

    Student findById (Integer id);

    List<Student> findAll();

    void deleteById(Integer id);

}
