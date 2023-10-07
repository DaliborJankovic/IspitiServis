package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao.ProfessorDAO;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Professor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    private ProfessorDAO professorDAO;

    public ProfessorServiceImpl(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }

    @Override
    @Transactional
    public void save(Professor theProfessor) {
        professorDAO.save(theProfessor);
    }

    @Override
    public Professor findById(Integer id) {
        return professorDAO.findById(id);
    }

    @Override
    public List<Professor> findAll() {
        return professorDAO.findAll();
    }

    @Override
    @Transactional
    public void update(Professor theProfessor) {
        professorDAO.update(theProfessor);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        professorDAO.delete(id);
    }
}
