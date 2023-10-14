package DaliborJankovic.StudentskiServis.entity.users;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "student")
@Data
public class Student extends PersonalData {

    @Column(length = 4, nullable = false, unique = true, name = "index_number")
    @NotEmpty
    @Size(min = 4, max = 4, message = ("Index Number must have 4 characters"))
    @Pattern(regexp = "^[0-9]+$", message = "Value must be an integer")
    private String indexNumber;

    @Column(nullable = false, name = "index_year")
//    @NotNull(message = "Field cannot be null")
    @Min(value = 2000, message = ("Index year must be greater than or equal to 2000"))
    @Max(value = 2100, message = ("Index year must be less than or equal to 2100"))
    private int indexYear;

    @Column(nullable = false, name = "current_year_of_study")
//    @NotNull(message = "Field cannot be null")
    @Min(value = 1)
    @Max(value = 5)
    private int currentYearOfStudy;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;

    //    metoda za dodavanje predmeta
    public void addSubject(Subject subject) {

        if (subjects == null) {
            subjects = new ArrayList<>();
        }

        subjects.add(subject);
    }

}


































