package DaliborJankovic.StudentskiServis.authoriti;

import DaliborJankovic.StudentskiServis.entity.users.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@IdClass(CompositeKey.class)
public class Authorities implements DaliborJankovic.StudentskiServis.entity.Entity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    @JsonBackReference
    private User username;

    @Id
    private String authority;

}
