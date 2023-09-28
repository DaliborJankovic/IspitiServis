package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet;


import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.enums.Semester;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subject")
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id")
    private int subId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "numberOfESP")
    private int numberOfESP;

    @Column(name = "yearOfStudy")
    private int yearOfStudy;

    @Column(name = "semester")
    private Semester semester;

}