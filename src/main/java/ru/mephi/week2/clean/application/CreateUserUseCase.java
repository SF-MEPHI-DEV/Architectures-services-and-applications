package ru.mephi.week1.week2.clean.application;

import org.springframework.stereotype.Service;
import ru.mephi.week1.week2.clean.domain.User;
import ru.mephi.week1.week2.clean.interfaces.UserRepository;

@Service
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }
}