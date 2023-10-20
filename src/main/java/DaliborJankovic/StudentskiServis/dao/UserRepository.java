package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
