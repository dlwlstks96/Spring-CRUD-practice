package com.example.crud.controller;

import com.example.crud.dto.UserDTO;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //CRUD
    // C -> POST
    // R -> GET
    // U -> PUT
    // D -> DELETE

    //user 매개 변수를 JSON으로 받아와야함. 때문에 @RequestBody 붙여줌.
    @PostMapping("")
    public UserDTO insertUser(@RequestBody UserDTO user) {
        return userService.insertUser(user);
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // {userId} 값이 매개 변수 @PathVariable userId로 매핑되어 들어간다.
    @GetMapping("/{userId}")
    public UserDTO getUserByUserId(@PathVariable String userId) {
        return userService.getUserByUserId(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserPw(@PathVariable String userId, @RequestBody UserDTO user) {
        userService.updateUserPw(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
