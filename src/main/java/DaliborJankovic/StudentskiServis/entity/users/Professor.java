package DaliborJankovic.StudentskiServis.entity.users;

import DaliborJankovic.StudentskiServis.entity.subjects.Subject;
import DaliborJankovic.StudentskiServis.entity.users.details.Title;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class Professor extends User {


    @Column(length = 15)
    @Size(min = 9, message = ("This field must have minimum 9 characters"))
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate reelectionDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "titleid")
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

    @Override
    public String toString() {
        return "Professor{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", reelectionDate=" + reelectionDate +
                ", title=" + title +
                '}';
    }
}
