package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.dtos.CartRequestDTO;
import com.robertoapi.login_and_authentication_api.dtos.CartResponseDTO;
import com.robertoapi.login_and_authentication_api.dtos.OrderRequestDTO;
import com.robertoapi.login_and_authentication_api.mappers.ProductMapper;
import com.robertoapi.login_and_authentication_api.mappers.UserMapper;
import com.robertoapi.login_and_authentication_api.model.Cart;
import com.robertoapi.login_and_authentication_api.repository.CartRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    public final CartRepository cartRepository;
    private final UserMapper userMapper;

    public CartService(CartRepository cartRepository, UserMapper userMapper){
        this.cartRepository = cartRepository;
        this.userMapper = userMapper;
    }

//------------------------------------------------------------------------------------------

    public void createCart(CartRequestDTO cartDTO){
        Cart cart = toEntity(cartDTO);
        cartRepository.save(cart);
    }


    public List<CartResponseDTO> findAllCarts(){
        return cartRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    public Optional<CartResponseDTO> findCartById(Long id){
        return cartRepository.findById(id)
                .map(this::toResponseDTO);
    }


    public void deleteCartById(Long id){
        cartRepository.deleteById(id);
    }


    public void updateCartById(Long id, CartRequestDTO updateCartDTO){
        Optional<Cart> cartDB = cartRepository.findById(id);

        if(cartDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found");
        }
        else{
            Cart editCart = cartDB.get();

            editCart.setName(updateCartDTO.getName());
            editCart.setUser(updateCartDTO.getUser());


            cartRepository.save(editCart);
        }
    }

//------------------------------------------------------------------------------------------
//DTOs


    private Cart toEntity(CartRequestDTO cartDTO){
        Cart cart = new Cart();

        cart.setName(cartDTO.getName());
        cart.setUser(cartDTO.getUser());
        cart.setItems(cartDTO.getItems());

        return cart;
    }


    private CartResponseDTO toResponseDTO(Cart cart){
        CartResponseDTO respDTO = new CartResponseDTO();

        respDTO.setName(cart.getName());
        respDTO.setUser(userMapper.toResponseDTO(cart.getUser()));
        respDTO.setItems(cart.getItems());

        return respDTO;
    }




}
