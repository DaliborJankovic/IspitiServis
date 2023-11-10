package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.ProfessorRepository;
import DaliborJankovic.StudentskiServis.entity.users.Professor;
import DaliborJankovic.StudentskiServis.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    @Transactional
    public void save(Professor theProfessor) {
        professorRepository.save(theProfessor);
    }

    @Override
    public Professor findById(String id) {
        Optional<Professor> result = professorRepository.findById(id);
        Professor tempProfessor = null;

        if (result.isPresent()) {
            tempProfessor = result.get();
        } else {
            throw new RuntimeException("There is no professor with id - " + id);
        }

        return tempProfessor;
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        professorRepository.deleteById(id);
    }
}
