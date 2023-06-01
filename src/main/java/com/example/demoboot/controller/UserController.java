package com.example.demoboot.controller;

import com.example.demoboot.entitiy.User;
import com.example.demoboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        User user = userService.get(id).orElse(null);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }

//    @GetMapping()
//    public String getAll(Model model) {
//        model.addAttribute("myName", "Kate");
//        model.addAttribute("usersList", userService.getAll());
//        return "index";
//    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, User user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
