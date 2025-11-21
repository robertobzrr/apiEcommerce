package com.robertoapi.login_and_authentication_api.mappers;

import com.robertoapi.login_and_authentication_api.dtos.ProductResponseDTO;
import com.robertoapi.login_and_authentication_api.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDTO toResponseDTO(Product product) {
        if (product == null) {
            return null;
        }
        else {

            ProductResponseDTO respDTO = new ProductResponseDTO();

            respDTO.setName(product.getName());
            respDTO.setDescription(product.getDescription());
            respDTO.setPrice(product.getPrice());

            return respDTO;
        }
    }


}
