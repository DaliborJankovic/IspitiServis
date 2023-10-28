package DaliborJankovic.StudentskiServis.entity.exams;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import DaliborJankovic.StudentskiServis.entity.users.Professor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam  implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "examperiod_id")
    private ExamPeriod examPeriod;

    @ManyToOne
    @JoinColumn(nullable = false, name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(nullable = false, name = "username")
    private Professor professor;

    @Column(nullable = false)
    private LocalDate dateOfExam;

}
