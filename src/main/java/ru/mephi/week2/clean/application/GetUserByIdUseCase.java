package ru.mephi.week2.clean.application;

import org.springframework.stereotype.Service;
import ru.mephi.week2.clean.domain.User;
import ru.mephi.week2.clean.interfaces.UserRepository;

@Service
public class GetUserByIdUseCase {
    private final UserRepository userRepository;

    public GetUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long id) {
        return userRepository.findById(id);
    }
}
