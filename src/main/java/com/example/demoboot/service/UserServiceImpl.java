package com.example.demoboot.service;

import com.example.demoboot.entitiy.User;
import com.example.demoboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        Optional<User> optional = userRepository.findById(user.getId());

        if (optional.isEmpty()) {
            return null;
        }

        User oldUser = optional.get();

        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());

        return userRepository.save(oldUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
