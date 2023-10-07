package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.service;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao.ProfessorRepository;
import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    @Transactional
    public void save(Professor theProfessor) {
        professorRepository.save(theProfessor);
    }

    @Override
    public Professor findById(Integer id) {
        Optional<Professor> result = professorRepository.findById(id);
        Professor tempProfessor = null;

        if (result.isPresent()) {
            tempProfessor = result.get();
        }
        else {
            throw new RuntimeException("There is no professor with id - " + id);
        }

        return tempProfessor;
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) { professorRepository.deleteById(id); }
}
