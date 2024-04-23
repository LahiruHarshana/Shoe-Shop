package lk.ijse.gdse66.shoeshopbackend.service;

import lk.ijse.gdse66.shoeshopbackend.dto.InventoryDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Inventory;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;

import java.util.List;

/**
 * @author : L.H.J
 * @File: InventoryService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
public interface InventoryService {
    public Integer saveInventory(InventoryDTO inventoryDTO) ;
    public Integer disable(String id);
    public Integer updateInventory(InventoryDTO inventoryDTO);
    public List<InventoryDTO> findAllInventory();
    public Integer enable(String id);
    public List<InventoryDTO> paginationInventory(PaginationDTO paginationDTO);
}
