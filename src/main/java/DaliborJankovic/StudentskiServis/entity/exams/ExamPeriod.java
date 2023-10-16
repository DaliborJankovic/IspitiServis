package DaliborJankovic.StudentskiServis.entity.exams;

import DaliborJankovic.StudentskiServis.enums.ExamPeriodStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "exam_period")
@Data
public class ExamPeriod implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = false, length = 30, name = "exam_period_name")
    private String examPeriodName;

    @Column(nullable = false, name = "start_date")
    private LocalDate startDate;

    @Column(nullable = false, name = "end_date")
    private LocalDate endDate;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private ExamPeriodStatus status;

}
