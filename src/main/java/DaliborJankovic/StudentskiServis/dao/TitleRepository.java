package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.users.details.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, Integer> {
}
