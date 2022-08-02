package com.example.crud.repository;

import com.example.crud.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    // TODO: db 연동 코드.. (JPA)

    //DB 연동 코드 작성 이전에 간단하게 기능 구현 위해서
    static public ArrayList<UserDTO> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDTO("kang", "test1", "1234"));
        users.add(new UserDTO("park", "test2", "1234"));
        users.add(new UserDTO("lee", "test3", "1234"));
    }

    //CREATE
    public UserDTO insertUser(UserDTO user) {
        users.add(user);
        return user;
    }

    //GET
    public List<UserDTO> getAllUsers() {
        return users;
    }

    //GET
    public UserDTO getUserByUserId(String userId) {
        return users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("", "", ""));
    }

    //UPDATE
    public void updateUserPw(String userId, UserDTO user) {
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("", "", ""))
                .setUserPw(user.getUserPw());
    }

    //DELETE
    public void deleteUser(String userId) {
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));
    }


}
