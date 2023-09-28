package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.enums.TeacherTitle;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "title")
@Data
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_id")
    private int titleId;

    @Column(name = "teacher_title")
    private TeacherTitle teacherTitle;

}
