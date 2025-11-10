package com.robertoapi.login_and_authentication_api.controller;

import com.robertoapi.login_and_authentication_api.model.TB_User;
import com.robertoapi.login_and_authentication_api.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody TB_User user){
        userService.createUser(user);
    }

}
