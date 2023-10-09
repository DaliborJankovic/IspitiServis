package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

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


}
