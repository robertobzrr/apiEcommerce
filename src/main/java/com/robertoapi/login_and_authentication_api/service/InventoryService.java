package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.dtos.InventoryRequestDTO;
import com.robertoapi.login_and_authentication_api.dtos.InventoryResponseDTO;
import com.robertoapi.login_and_authentication_api.model.Inventory;
import com.robertoapi.login_and_authentication_api.repository.InventoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

//---------------------------------------------------------------------------------------

    public void createInventory(InventoryRequestDTO inventoryDTO){
        Inventory inventory = toEntity(inventoryDTO);
        inventoryRepository.save(inventory);
    }


    public List<InventoryResponseDTO> findAllInventorys(){
        return inventoryRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    public Optional<InventoryResponseDTO> findInventoryById(Long id){
        return inventoryRepository.findById(id).map(this::toResponseDTO);
    }


    public void deleteInventoryById(Long id){
        inventoryRepository.deleteById(id);
    }


    public void updateInventoryById(Long id, InventoryRequestDTO updateInventoryDTO){
        Optional<Inventory> inventoryDB = inventoryRepository.findById(id);

        if(inventoryDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found");
        }
        else{
            Inventory editInventory = inventoryDB.get();

            editInventory.setQuantity(updateInventoryDTO.getQuantity());

            inventoryRepository.save(editInventory);
        }
    }


//------------------------------------------------------------------------------------------
//DTOs

    private Inventory toEntity(InventoryRequestDTO inventoryDTO){
        Inventory inventory = new Inventory();

        inventory.setQuantity(inventoryDTO.getQuantity());
        inventory.setProduct(inventoryDTO.getProduct());

        return inventory;
    }


    private InventoryResponseDTO toResponseDTO(Inventory inventory){
        InventoryResponseDTO respDTO = new InventoryResponseDTO();

        respDTO.setQuantity(inventory.getQuantity());
        respDTO.setProduct((inventory.getProduct()));

        return respDTO;
    }







}
