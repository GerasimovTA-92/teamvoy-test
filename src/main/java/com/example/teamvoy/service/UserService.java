package com.example.teamvoy.service;

import com.example.teamvoy.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByEmail(String email);

    List<User> findAll();

    User save(User user);
}
