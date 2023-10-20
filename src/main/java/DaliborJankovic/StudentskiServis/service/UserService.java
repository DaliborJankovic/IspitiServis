package DaliborJankovic.StudentskiServis.service;

import DaliborJankovic.StudentskiServis.entity.users.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findById (String id);

    List<User> findAll();

    void deleteById(String id);

}
