package DaliborJankovic.StudentskiServis.authoriti;

import DaliborJankovic.StudentskiServis.entity.users.User;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
public class CompositeKey implements Serializable {

    private User username;
    private String authority;
}
