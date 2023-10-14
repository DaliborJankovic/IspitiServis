package DaliborJankovic.StudentskiServis.entity.users;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import DaliborJankovic.StudentskiServis.entity.users.details.Title;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "professor")
@Data
public class Professor extends PersonalData {


    @Column(length = 15, name = "phone_number")
    @Size(min = 9, message = ("This field must have minimum 9 characters"))
    private String phoneNumber;

    @Column(nullable = false, name = "reelection_date")
//    @NotNull(message = "Field cannot be null")
    private LocalDate reelectionDate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn( nullable = false, name = "title")
//    @NotNull(message = "Field cannot be null")
    private Title title;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "professor_subject",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

    //    metoda za dodavanje predmeta
    public void addSubject(Subject subject) {

        if (subjects == null) {
            subjects = new ArrayList<>();
        }

        subjects.add(subject);
    }

}
