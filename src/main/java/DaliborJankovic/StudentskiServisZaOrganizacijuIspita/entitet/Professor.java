package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name = "professor")
@Data
public class Professor extends PersonalData{


    @Column(name = "phone_number")
    @Size(min = 9, message = ("This field must have minimum 9 characters"))
    private String phoneNumber;

    @Column(name = "reelection_date")
    private Date reelectionDate;

    @ManyToOne
    @JoinColumn(name = "title")
    private Title title;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                           CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "professor_subject",
            joinColumns = @JoinColumn (name = "professor_id"),
            inverseJoinColumns = @JoinColumn (name = "subject_id")
    )
    private List<Subject> subjects;


}
