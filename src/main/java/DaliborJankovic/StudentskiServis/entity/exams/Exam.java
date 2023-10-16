package DaliborJankovic.StudentskiServis.entity.exams;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table
@Data
public class Exam  implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "exam_period_id")
    private ExamPeriod examPeriod;

    @ManyToOne
    @JoinColumn(nullable = false, name = "subject_id")
    private Subject subject;

    @Column(nullable = false, name = "date_of_exam")
    private LocalDate dateOfExam;

}
