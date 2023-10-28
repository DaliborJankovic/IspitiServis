package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Modifying
    @Query(value = "INSERT INTO professor_subject (professor_id, subject_id) VALUES (:professorId, :subjectId)", nativeQuery = true)
    void addProfessorToSubject(@Param("professorId") String professorId, @Param("subjectId") Long subjectId);

    @Modifying
    @Query(value = "DELETE FROM professor_subject WHERE professor_id = (:professorId) AND subject_id = (:subjectId)", nativeQuery = true)
    void deleteProfessorFromSubject(@Param("professorId") String professorId, @Param("subjectId") Long subjectId);
}

