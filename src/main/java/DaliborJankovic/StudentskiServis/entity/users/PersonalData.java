package DaliborJankovic.StudentskiServis.entity.users;

import DaliborJankovic.StudentskiServis.entity.users.details.City;
import DaliborJankovic.StudentskiServis.validation.Email;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@MappedSuperclass
@Table(name = "personal_data")
@Data
public abstract class PersonalData implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 30, nullable = false, name = "first_name")
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    @NotEmpty
    private String firstName;

    @Column(length = 30, nullable = false, name = "last_name")
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    @NotEmpty
    private String lastName;

    @Column(length = 30, unique = true, name = "email")
    @Email
    private String eMail;

    @Column(length = 50, name = "address")
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    private String address;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "postal_code")
    private City postalCode;

}
