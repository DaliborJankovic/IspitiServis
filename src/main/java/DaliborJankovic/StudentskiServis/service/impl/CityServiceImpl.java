package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.CityRepository;
import DaliborJankovic.StudentskiServis.entity.users.details.City;
import DaliborJankovic.StudentskiServis.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public City findById(Integer id) {
        Optional<City> result = cityRepository.findById(id);
        City tempCity = null;
        if (result.isPresent()) {
            tempCity = result.get();
        } else {
            throw new RuntimeException("City not found!");
        }
        return null;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }
}
