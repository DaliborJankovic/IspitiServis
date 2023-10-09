package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "student")
@Data
public class Student extends PersonalData{

    @Column(name = "index_number")
    @Size(min = 4, max = 4, message = ("Index Number must have 4 characters"))
    @Pattern(regexp = "^[0-9]+$", message = "Value must be an integer")
    private String indexNumber;

    @Column(name = "index_year")
    @Min(value = 2000, message = ("Index year must be greater than or equal to 2000"))
    @Max(value = 2100, message = ("Index year must be less than or equal to 2100"))
    private int indexYear;

    @Column(name = "current_year_of_study")
    private int currentYearOfStudy;

}


































