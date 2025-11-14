package com.robertoapi.login_and_authentication_api.controller;

import com.robertoapi.login_and_authentication_api.model.Inventory;
import com.robertoapi.login_and_authentication_api.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventorys")
public class InventoryController {

    private final InventoryService inventoryService;

    private InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

//------------------------------------------------------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@RequestBody Inventory inventory){
        inventoryService.createInventory(inventory);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> findAllInventory(){
        return inventoryService.findAllInventorys();
    }


    @GetMapping("{/id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Inventory> findInventoryById(@PathVariable Long id){
        return inventoryService.findInventoryById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInventoryById(@PathVariable Long id){
        inventoryService.deleteInventoryById(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInventoryById(@PathVariable Long id, @RequestBody Inventory updateInventory){
        inventoryService.updateInventoryById(id, updateInventory);
    }



}
