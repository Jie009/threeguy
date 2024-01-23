package com.threeguy.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //处理validation

    @Autowired
    private UserRepository userRepository;

    public boolean validateUserCredentials(String username, String password) {
        User userFromDb = userRepository.findByUsername(username);

        return userFromDb != null && userFromDb.getPassword().equals(password);
    }
}
