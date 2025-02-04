package lk.ijse.gdse66.shoeshopbackend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.gdse66.shoeshopbackend.dto.InventoryDTO;
import lk.ijse.gdse66.shoeshopbackend.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author : L.H.J
 * @File: InventoryController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<?> saveInventory(@RequestParam("item") String inventory, @RequestParam("itemImage") MultipartFile file) throws IOException {
        InventoryDTO inventoryDTO = new ObjectMapper().readValue(inventory, InventoryDTO.class);
        boolean isSave = inventoryService.saveInventory(inventoryDTO, file);
        return isSave ? ResponseEntity.ok("Inventory Saved !") : ResponseEntity.badRequest().body("Failed to save the inventory");
    }

    @GetMapping("/available")
    public ResponseEntity<?> getAvailableInventory(){
        return ResponseEntity.ok(inventoryService.getAvailableInventory());
    }

    @GetMapping
    public ResponseEntity<?> getAllInventory(){
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }

    @GetMapping("/{itemCode}")
    public ResponseEntity<?> getInventory(@PathVariable String itemCode){
        return ResponseEntity.ok(inventoryService.getInventory(itemCode));
    }

    @PutMapping
    public ResponseEntity<?> updateInventory(@RequestParam("item") String inventory, @RequestParam("itemImage") MultipartFile file) throws IOException {
        InventoryDTO inventoryDTO = new ObjectMapper().readValue(inventory, InventoryDTO.class);
        boolean isSave = inventoryService.updateInventory(inventoryDTO, file);
        return isSave ? ResponseEntity.ok("Inventory Updated !") : ResponseEntity.badRequest().body("Failed to update the inventory");
    }

    @GetMapping("/get/brands")
    public ResponseEntity<?> getBrands(){
        return ResponseEntity.ok(inventoryService.getBrands());
    }

    @GetMapping("/available/{brand}")
    public ResponseEntity<?> getAvailableInventory(@PathVariable String brand){
        return ResponseEntity.ok(inventoryService.getAvailableBrandItems(brand));
    }
}
