package DaliborJankovic.StudentskiServis.entity.exams;

import DaliborJankovic.StudentskiServis.entity.users.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamRegistration implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "examid")
    private Exam exam;

    @Column(nullable = true)
    private int grade;

}
