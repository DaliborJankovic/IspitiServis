package DaliborJankovic.StudentskiServis.entity.users.details;

import DaliborJankovic.StudentskiServis.enums.TeacherTitle;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "title")
@Data
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_id")
    private Long titleId;

    @Column(name = "teacher_title")
    @Enumerated(EnumType.STRING)
    private TeacherTitle teacherTitle;

    @Override
    public String toString() {
        return teacherTitle + "";
    }
}
