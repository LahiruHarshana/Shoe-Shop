package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.InventoryDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Inventory;
import lk.ijse.gdse66.shoeshopbackend.repository.InventoryRepository;
import lk.ijse.gdse66.shoeshopbackend.service.InventoryService;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : L.H.J
 * @File: InventoryServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    InventoryServiceImpl(InventoryRepository inventoryRepository, ModelMapper modelMapper){
        this.inventoryRepository = inventoryRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Integer saveInventory(InventoryDTO inventoryDTO) {
        inventoryDTO.setActive(true);
        inventoryRepository.save(modelMapper.map(inventoryDTO, Inventory.class));
        return 200;
    }

    @Override
    public Integer disable(String id) {
        Inventory inventory = inventoryRepository.findById(id).orElse(null);
        if (inventory != null) {
            inventory.setActive(false);
            inventoryRepository.save(inventory);
            return 200;
        }
        return 500;
    }

    @Override
    public Integer updateInventory(InventoryDTO inventoryDTO) {
        if (inventoryRepository.existsById(inventoryDTO.getItemCode())) {
            Inventory entity = modelMapper.map(inventoryDTO, Inventory.class);
            inventoryRepository.save(entity);
            return 200;
        }
        return 500;
    }

    @Override
    public List<InventoryDTO> findAllInventory() {
        return inventoryRepository.findAll().stream()
                .map(inventory -> modelMapper.map(inventory, InventoryDTO.class)).toList();
    }

    @Override
    public Integer enable(String id) {
        Inventory inventory = inventoryRepository.findById(id).orElse(null);
        if (inventory != null) {
            inventory.setActive(true);
            inventoryRepository.save(inventory);
            return 200;
        }
        return 500;
    }

    @Override
    public List<InventoryDTO> paginationInventory(PaginationDTO paginationDTO) {
        return inventoryRepository
                .findAll(CommonUtils.setPagination(paginationDTO.getOffset(), paginationDTO.getLimit(), paginationDTO.getColumnName()))
                .stream().map(inventory -> modelMapper.map(inventory, InventoryDTO.class)).toList();

    }
}
