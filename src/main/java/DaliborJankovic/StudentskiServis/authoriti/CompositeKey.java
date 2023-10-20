package DaliborJankovic.StudentskiServis.authoriti;

import DaliborJankovic.StudentskiServis.entity.users.User;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;

@EqualsAndHashCode(callSuper = false)
public class CompositeKey implements Serializable {

    private User username;
    private String authority;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CompositeKey that = (CompositeKey) o;
//        return Objects.equals(username, that.username) && Objects.equals(authority, that.authority);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, authority);
//    }
}
