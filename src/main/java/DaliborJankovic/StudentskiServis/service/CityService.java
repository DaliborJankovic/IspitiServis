package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.users.details.City;

import java.util.List;

public interface CityService {

    void save(City city);

    City findById (Integer id);

    List<City> findAll();

    void deleteById(Integer id);
}
