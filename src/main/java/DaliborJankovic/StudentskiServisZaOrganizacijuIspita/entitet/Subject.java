package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet;


import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.enums.Semester;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "subject")
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id")
    private int subId;

    @Column(name = "name")
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "numberOfESP")
    private int numberOfESP;

    @Column(name = "yearOfStudy")
    private int yearOfStudy;

    @Column(name = "semester")
    private Semester semester;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "professor_subject",
            joinColumns = @JoinColumn (name = "subject_id"),
            inverseJoinColumns = @JoinColumn (name = "professor_id")
    )
    private List<Professor> professors;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn (name = "sub_id"),
            inverseJoinColumns = @JoinColumn (name = "student_id")
    )
    private List<Student> students;


}
