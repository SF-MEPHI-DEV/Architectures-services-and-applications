package ru.mephi.week2.clean.interfaces;

import ru.mephi.week2.clean.domain.User;

public interface UserRepository {
    User save(User user);
    User findById(Long id);
}