package com.robertoapi.login_and_authentication_api.controller;

import com.robertoapi.login_and_authentication_api.model.TB_Product;
import com.robertoapi.login_and_authentication_api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody TB_Product product){
        productService.createProduct(product);
    }



}
