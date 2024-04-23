package lk.ijse.gdse66.shoeshopbackend.controller;

import lk.ijse.gdse66.shoeshopbackend.dto.InventoryDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.ResponseDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SupplierDTO;
import lk.ijse.gdse66.shoeshopbackend.service.InventoryService;
import lk.ijse.gdse66.shoeshopbackend.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author : L.H.J
 * @File: InventoryController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @PostMapping
    public ResponseDTO saveInventory(@RequestBody InventoryDTO inventoryDTO){
        try {
            System.out.println("Inventory save"+inventoryDTO);
            return new ResponseDTO("Inventory saved successfully", inventoryService.saveInventory(inventoryDTO));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/dis/{id}")
    public ResponseDTO disabledInventory(@PathVariable String id) {
        try {
            return new ResponseDTO("Inventory disabled successfully", inventoryService.disable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/enb/{id}")
    public ResponseDTO enabledInventory(@PathVariable String id) {
        try {
            return new ResponseDTO("Inventory enabled successfully", inventoryService.enable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }
    @GetMapping("/{type}/{value}")
    public ResponseDTO getSelectInventory(@PathVariable String type, @PathVariable String value) {
        return null;
    }

    @PostMapping("/pagination")
    public ResponseDTO getAllInventory(@RequestBody PaginationDTO paginationDTO) {
        try {
            HashMap<String, Object> map = new HashMap<>();
            if (paginationDTO == null) {
                map.put("Inventory", inventoryService.findAllInventory());
            }else {
                map.put("Inventory", inventoryService.paginationInventory(paginationDTO));
            }
            return new ResponseDTO("Inventory found successfully",200, map);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @GetMapping
    public List<InventoryDTO> getAllInventory() {
        List<InventoryDTO> inventoryDTOS = inventoryService.findAllInventory();
        if (!inventoryDTOS.isEmpty()) {
            return inventoryDTOS;
        } else {
            return null;
        }
    }
}
