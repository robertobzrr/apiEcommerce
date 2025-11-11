package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.model.TB_Product;
import com.robertoapi.login_and_authentication_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void createProduct(TB_Product product){
        productRepository.save(product);
    }





}
