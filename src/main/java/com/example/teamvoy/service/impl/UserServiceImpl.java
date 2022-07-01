package com.example.teamvoy.service.impl;

import com.example.teamvoy.model.User;
import com.example.teamvoy.repository.UserRepository;
import com.example.teamvoy.service.ShoppingCartService;
import com.example.teamvoy.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder encoder,
                           ShoppingCartService shoppingCartService) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        shoppingCartService.createShoppingCart(user);
        return userRepository.save(user);
    }
}
