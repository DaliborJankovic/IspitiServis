package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao.StudentRepository;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> result = studentRepository.findById(id);
        Student tempStudent = null;

        if (result.isPresent()) {
            tempStudent = result.get();
        } else {
            throw new RuntimeException("There is no student with id - " + id);
        }

        return tempStudent;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}
