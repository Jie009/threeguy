package com.threeguy.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//接收api
public class UserController {

    @Autowired
    private UserService userService;
    private UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User loginUser) {
        if (userService.validateUserCredentials(loginUser.getUsername(), loginUser.getPassword())) {
            return new LoginResponse(true, "Login successful");
        } else {
            return new LoginResponse(false, "Invalid username or password");
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    private static class LoginResponse {
        private final boolean success;
        private final String message;

        public LoginResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}