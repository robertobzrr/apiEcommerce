package com.robertoapi.login_and_authentication_api.dtos;

import com.robertoapi.login_and_authentication_api.model.Product;
import lombok.Data;

@Data
public class InventoryResponseDTO {
    private Integer quantity;
    private ProductResponseDTO product;
}
