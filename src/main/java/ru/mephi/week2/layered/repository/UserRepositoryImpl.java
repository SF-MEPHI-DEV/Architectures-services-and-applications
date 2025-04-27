package ru.mephi.week1.week2.layered.repository;

import ru.mephi.week1.week2.layered.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> database = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter++);
        }
        database.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return database.get(id);
    }
}