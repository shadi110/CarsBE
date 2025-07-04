package com.carBE.demo.Services;

import java.util.List;

import com.carBE.demo.dto.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}