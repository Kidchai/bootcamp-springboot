package com.example.demoboot.service;

import com.example.demoboot.entitiy.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);
    Optional<User> get(Long id);
    List<User> getAll();
    User update(Long id, User user);
    void delete(Long id);
}
