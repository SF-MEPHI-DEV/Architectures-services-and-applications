package ru.mephi.week2.layered.repository;


import ru.mephi.week2.layered.model.User;

public interface UserRepository {
    User save(User user);
    User findById(Long id);
}