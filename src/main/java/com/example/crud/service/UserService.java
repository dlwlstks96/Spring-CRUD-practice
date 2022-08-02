package com.example.crud.service;

import com.example.crud.dto.UserDTO;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //CREATE
    public UserDTO insertUser(UserDTO user) {
        return userRepository.insertUser(user);
    }

    //GET
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers();
    }

    //GET
    public UserDTO getUserByUserId(String userId) {
        return userRepository.getUserByUserId(userId);
    }

    //UPDATE
    public void updateUserPw(String userId, UserDTO user) {
        userRepository.updateUserPw(userId, user);
    }

    //DELETE
    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }


}
