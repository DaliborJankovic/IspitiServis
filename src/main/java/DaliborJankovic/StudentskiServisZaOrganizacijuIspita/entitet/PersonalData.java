package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet;

import DaliborJankovic.StudentskiServisZaOrganizacijuIspita.validation.Email;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@MappedSuperclass
@Table(name = "personal_data")
@Data
public abstract class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    private String lastName;

    @Column(name = "email")
    @Email
    private String eMail;

    @Column(name = "address")
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    private String address;

    @ManyToOne
    @JoinColumn(name = "postal_code")
    private City postalCode;

}
