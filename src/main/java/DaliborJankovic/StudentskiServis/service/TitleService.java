package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.users.details.Title;

import java.util.List;

public interface TitleService {

    void save(Title title);

    Title findById (Integer id);

    List<Title> findAll();

    void deleteById(Integer id);
}
