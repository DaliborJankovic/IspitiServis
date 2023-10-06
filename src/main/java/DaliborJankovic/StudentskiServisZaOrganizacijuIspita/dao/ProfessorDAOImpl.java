package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProfessorDAOImpl implements ProfessorDAO{

    private EntityManager entityManager;

    @Autowired
    public ProfessorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Professor theProfessor) {
        entityManager.persist(theProfessor);
    }

    @Override
    public Professor findById(Integer id) {
        return entityManager.find(Professor.class, id);
    }

    @Override
    public List<Professor> findByAll() {

        TypedQuery theQuery = entityManager.createQuery("FROM Professor", Professor.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Professor theProfessor) {
        entityManager.merge(theProfessor);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(entityManager.find(Professor.class, id));
    }
}
