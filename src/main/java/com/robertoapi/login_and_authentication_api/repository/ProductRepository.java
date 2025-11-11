package com.robertoapi.login_and_authentication_api.repository;

import com.robertoapi.login_and_authentication_api.model.TB_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<TB_Product, Long> {
}
