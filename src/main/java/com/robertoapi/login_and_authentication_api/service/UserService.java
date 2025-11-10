package com.robertoapi.login_and_authentication_api.service;
import com.robertoapi.login_and_authentication_api.model.TB_User;
import com.robertoapi.login_and_authentication_api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public void createUser(TB_User user){
        userRepository.save(user);
    }

}
