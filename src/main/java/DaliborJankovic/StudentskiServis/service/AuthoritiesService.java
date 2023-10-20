package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.authoriti.Authorities;

import java.util.List;

public interface AuthoritiesService {

    void save(Authorities authorities);

    Authorities findById (Integer id);

    List<Authorities> findAll();

    void deleteById(Integer id);

}
