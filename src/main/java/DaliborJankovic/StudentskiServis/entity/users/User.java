package DaliborJankovic.StudentskiServis.entity.users;

import DaliborJankovic.StudentskiServis.authoriti.Authorities;
import DaliborJankovic.StudentskiServis.entity.users.details.City;
import DaliborJankovic.StudentskiServis.validation.Email;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @Column(length = 30, nullable = false)
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    private String username;

    @Column(length = 30, nullable = false)
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    private String password;


    @Column(length = 30, nullable = false)
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    @NotEmpty
    private String firstName;

    @Column(length = 30, nullable = false)
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    @NotEmpty
    private String lastName;

    @Column(length = 30, unique = true)
    @Email
    private String eMail;

    @Column(length = 50)
    @Size(min = 3, message = ("This field must have minimum 3 characters"))
    private String address;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "postal_code")
    private City postalCode;

    @OneToMany(mappedBy = "username", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Authorities> authoritiesList;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setRole(String role) {
        if (this.getAuthoritiesList() == null) {
            this.setAuthoritiesList(new ArrayList<>());
        }
        this.getAuthoritiesList().add(new Authorities(this, role));
    }

}
