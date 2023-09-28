package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.entitet;

import jakarta.persistence.*;
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
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String eMail;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "postal_code")
    private City postalCode;

}
