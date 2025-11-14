package com.robertoapi.login_and_authentication_api.repository;

import com.robertoapi.login_and_authentication_api.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
