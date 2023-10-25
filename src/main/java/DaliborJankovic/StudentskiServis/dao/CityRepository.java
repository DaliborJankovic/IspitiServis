package DaliborJankovic.StudentskiServis.dao;

import DaliborJankovic.StudentskiServis.entity.users.details.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository <City, Integer> {
}
