package DaliborJankovic.StudentskiServis.entity.exams;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import DaliborJankovic.StudentskiServis.enums.ExamPeriodStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exam_period")
@Data
public class ExamPeriod implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "exam_period_name")
    private String examPeriodName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ExamPeriodStatus status;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_period_id")
    List<Subject> subjectList;

    //    metoda za dodavanje ispita u ispitni rok
    public void addSubject(Subject subject) {

        if (subjectList == null) {
            subjectList = new ArrayList<>();
        }

        subjectList.add(subject);
    }

}
