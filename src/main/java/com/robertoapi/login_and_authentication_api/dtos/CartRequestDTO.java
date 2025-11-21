package com.robertoapi.login_and_authentication_api.dtos;

import com.robertoapi.login_and_authentication_api.model.CartItem;
import com.robertoapi.login_and_authentication_api.model.User;
import lombok.Data;

import java.util.List;

@Data
public class CartRequestDTO {

    private String name;
    private User user;
    private List<CartItem> items;
}
