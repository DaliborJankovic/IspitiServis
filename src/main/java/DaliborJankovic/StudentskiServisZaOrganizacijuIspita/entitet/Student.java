package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "student")
@Data
public class Student extends PersonalData{

    @Column(name = "index_number")
    private String indexNumber;

    @Column(name = "index_year")
    private int indexYear;

    @Column(name = "current_year_of_study")
    private int currentYearOfStudy;

}


































