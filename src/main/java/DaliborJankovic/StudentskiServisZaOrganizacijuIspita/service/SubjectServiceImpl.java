package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao.SubjectDAO;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    private SubjectDAO subjectDAO;

    public SubjectServiceImpl(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    @Override
    @Transactional
    public void save(Subject theSubject) {
        subjectDAO.save(theSubject);
    }

    @Override
    public Subject findById(Integer id) {
        return subjectDAO.findById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subjectDAO.findAll();
    }

    @Override
    @Transactional
    public void update(Subject theSubject) {
        subjectDAO.update(theSubject);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        subjectDAO.delete(id);
    }
}
