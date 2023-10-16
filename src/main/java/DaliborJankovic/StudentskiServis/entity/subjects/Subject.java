package DaliborJankovic.StudentskiServis.entity.subjects;


import DaliborJankovic.StudentskiServis.entity.users.Professor;
import DaliborJankovic.StudentskiServis.enums.Semester;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
@Data
public class Subject implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id")
    private Long subId;

    @Column(length = 30, nullable = false, name = "name")
    @NotEmpty
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    private String name;

    @Column(length = 200, name = "description")
    private String description;

    @Column(length = 1, nullable = false, name = "number_of_esp")
//    @NotNull(message = "Field cannot be null")
    private int numberOfESP;

    @Column(length = 1, nullable = false, name = "year_of_study")
//    @NotNull(message = "Field cannot be null")
    private int yearOfStudy;

    @Column(length = 10, nullable = false, name = "semester")
//    @NotNull(message = "Field cannot be null")
    @Enumerated(EnumType.STRING)
    private Semester semester;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "professor_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> professors;

//        metoda za dodavanje Profesora
    public void addProfessor(Professor professor) {

        if (professors == null) {
            professors = new ArrayList<>();
        }

        professors.add(professor);
    }

}
