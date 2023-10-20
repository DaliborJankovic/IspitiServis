package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.authoriti.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {
}
