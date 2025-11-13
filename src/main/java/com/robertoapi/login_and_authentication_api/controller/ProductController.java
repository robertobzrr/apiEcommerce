package com.robertoapi.login_and_authentication_api.controller;

import com.robertoapi.login_and_authentication_api.model.Product;
import com.robertoapi.login_and_authentication_api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

//-----------------------------------------------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllProducts(){
        return productService.findAllUsers();
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> findUserById(Long id){
        return productService.findUserById(id);
    }



}
