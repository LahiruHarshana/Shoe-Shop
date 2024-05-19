package lk.ijse.gdse66.shoeshopbackend.service;

import lk.ijse.gdse66.shoeshopbackend.dto.InventoryDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author : L.H.J
 * @File: InventoryService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
public interface InventoryService {
    boolean saveInventory(InventoryDTO inventoryDTO, MultipartFile file) throws IOException;

    List<InventoryDTO> getAvailableInventory();

    List<InventoryDTO> getAllInventory();

    InventoryDTO getInventory(String itemCode);

    boolean updateInventory(InventoryDTO inventoryDTO, MultipartFile file) throws IOException;

    List<String> getBrands();

    List<InventoryDTO> getAvailableBrandItems(String brand);
}
