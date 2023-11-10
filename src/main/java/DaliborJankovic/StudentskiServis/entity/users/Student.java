package DaliborJankovic.StudentskiServis.entity.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class Student extends User {

    @Column(length = 4, nullable = false, unique = true)
    @NotEmpty
    @Size(min = 4, max = 4, message = ("Index Number must have 4 characters"))
    @Pattern(regexp = "^[0-9]+$", message = "Value must be an integer")
    private String indexNumber;

    @Column(nullable = false)
    @Min(value = 2000, message = ("Index year must be greater than or equal to 2000"))
    @Max(value = 2100, message = ("Index year must be less than or equal to 2100"))
    private int indexYear;

    @Column(nullable = false)
    @Min(value = 1)
    @Max(value = 5)
    private int currentYearOfStudy;

}


































