package DaliborJankovic.StudentskiServis.entity.exams;

import DaliborJankovic.StudentskiServis.entity.users.Student;
import jakarta.persistence.*;

public class ExamRegistration implements DaliborJankovic.StudentskiServis.entity.Entity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name = "username")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @Column(nullable = false, name = "grade")
    private int grade;

}
