package com.robertoapi.login_and_authentication_api.dto;

import com.robertoapi.login_and_authentication_api.model.Cart;
import com.robertoapi.login_and_authentication_api.model.Order;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponseDTO {
    private String name;
    private String email;
}
