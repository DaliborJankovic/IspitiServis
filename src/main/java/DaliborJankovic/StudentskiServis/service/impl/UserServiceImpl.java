package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.UserRepository;
import DaliborJankovic.StudentskiServis.entity.users.User;
import DaliborJankovic.StudentskiServis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        Optional<User> result = userRepository.findById(id);
        User tempUser = null;
        if(result.isPresent()) {
            tempUser = result.get();
        }
        else {
            throw new RuntimeException("User not found!");
        }
        return tempUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
