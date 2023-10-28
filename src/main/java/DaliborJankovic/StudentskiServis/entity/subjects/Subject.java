package DaliborJankovic.StudentskiServis.entity.subjects;

import DaliborJankovic.StudentskiServis.entity.users.Professor;
import DaliborJankovic.StudentskiServis.enums.Semester;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subId;

    @Column(length = 30, nullable = false)
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    @NotEmpty
    private String name;

    @Column(length = 200)
    private String description;

    @Column(length = 1, nullable = false)
    private int numberOfESP;

    @Column(length = 1, nullable = false)
    private int yearOfStudy;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Semester semester;

    @ManyToMany(mappedBy = "subjects")
    private List<Professor> professors;

    //        metoda za dodavanje Profesora
    public void addProfessor(Professor professor) {

        if (professors == null) {
            professors = new ArrayList<>();
        }
        professors.add(professor);
    }

}
