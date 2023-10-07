package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.dao;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDAOImpl implements SubjectDAO{

    private EntityManager entityManager;

    @Autowired
    public SubjectDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Subject theSubject) {
        entityManager.persist(theSubject);
    }

    @Override
    public Subject findById(Integer id) {
        return entityManager.find(Subject.class, id);
    }

    @Override
    public List<Subject> findAll() {

        TypedQuery theQuery = entityManager.createQuery("FROM Subject", Subject.class);

        return theQuery.getResultList();
    }

    @Override
    public void update(Subject theSubject) {
        entityManager.merge(theSubject);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(entityManager.find(Subject.class, id));
    }
}
