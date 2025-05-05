package ru.mephi.week2.layered.service;


import org.springframework.stereotype.Service;
import ru.mephi.week2.layered.model.User;
import ru.mephi.week2.layered.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }
}
