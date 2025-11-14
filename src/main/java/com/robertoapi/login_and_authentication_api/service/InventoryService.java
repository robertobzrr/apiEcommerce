package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.model.Inventory;
import com.robertoapi.login_and_authentication_api.repository.InventoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

//---------------------------------------------------------------------------------------

    public void createInventory(Inventory inventory){
        inventoryRepository.save(inventory);
    }


    public List<Inventory> findAllInventorys(){
        return inventoryRepository.findAll();
    }


    public Optional<Inventory> findInventoryById(Long id){
        return inventoryRepository.findById(id);
    }


    public void deleteInventoryById(Long id){
        inventoryRepository.deleteById(id);
    }


    public void updateInventoryById(Long id, Inventory updateInventory){
        Optional<Inventory> inventoryyDB = findInventoryById(id);

        if(inventoryyDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found");
        }
        else{
            Inventory editInventory = inventoryyDB.get();

            editInventory.setEstoque(updateInventory.getEstoque());

            inventoryRepository.save(editInventory);
        }
    }




}
