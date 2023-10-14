package DaliborJankovic.StudentskiServis.entity.users.details;

import DaliborJankovic.StudentskiServis.enums.TeacherTitle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "title")
@Data
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_id")
    private Long titleId;

    @Column(nullable = false, name = "teacher_title")
//    @NotNull(message = "Field cannot be null")
    @Enumerated(EnumType.STRING)
    private TeacherTitle teacherTitle;

}
