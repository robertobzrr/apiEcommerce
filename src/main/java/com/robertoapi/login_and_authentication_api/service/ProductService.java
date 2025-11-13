package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.model.Product;
import com.robertoapi.login_and_authentication_api.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

//---------------------------------------------------------------------------------------

    public void createProduct(Product product){
        productRepository.save(product);
    }


    public List<Product> findAllUsers(){
        return productRepository.findAll();
    }


    public Optional<Product> findUserById(Long id){
        return productRepository.findById(id);
    }


    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


    public void updateProductById(Long id, Product updateProduct){
        Optional<Product> productDB = findUserById(id);

        if(productDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        else{
            Product editProduct = productDB.get();


        }
    }







}
