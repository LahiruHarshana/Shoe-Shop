package lk.ijse.gdse66.shoeshopbackend.service.impl;


import lk.ijse.gdse66.shoeshopbackend.dto.InventoryDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Inventory;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemStatus;
import lk.ijse.gdse66.shoeshopbackend.repo.InventoryRepo;
import lk.ijse.gdse66.shoeshopbackend.repo.SupplierRepo;
import lk.ijse.gdse66.shoeshopbackend.service.InventoryService;
import lk.ijse.gdse66.shoeshopbackend.service.UploadService;
import lk.ijse.gdse66.shoeshopbackend.util.IDGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author : L.H.J
 * @File: InventoryServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepo inventoryRepo;

    private final ModelMapper modelMapper;

    private final UploadService uploadService;

    private final SupplierRepo supplierRepo;

    public InventoryServiceImpl(InventoryRepo inventoryRepo, ModelMapper modelMapper, UploadService uploadService, SupplierRepo supplierRepo) {
        this.inventoryRepo = inventoryRepo;
        this.modelMapper = modelMapper;
        this.uploadService = uploadService;
        this.supplierRepo = supplierRepo;
    }

    @Override
    public boolean saveInventory(InventoryDTO inventoryDTO, MultipartFile file) throws IOException {
        String image = uploadService.uploadFile(file);
        Inventory map = modelMapper.map(inventoryDTO, Inventory.class);
        map.setSupplier(supplierRepo.findById(inventoryDTO.getSupplierId()).get());
        map.setItemPicture(image);
        map.setItemSoldCount(0);
        map.setGetStockTotal(inventoryDTO.getQtyOnHand());
        map.setSupplierName(map.getSupplier().getSupplierName());
        map.setItemCode(IDGenerator.generateItemCode(inventoryDTO.getItemGender(), inventoryDTO.getItemType(), inventoryDTO.getItemDescription()));
        inventoryRepo.save(map);
        return true;
    }

    @Override
    public List<InventoryDTO> getAvailableInventory() {
        return inventoryRepo.findAllByItemStatusNot(ItemStatus.NOT_AVAILABLE).stream().map(inventory -> modelMapper.map(inventory, InventoryDTO.class)).toList();
    }

    @Override
    public List<InventoryDTO> getAllInventory() {
        return inventoryRepo.findAll().stream().map(inventory -> modelMapper.map(inventory, InventoryDTO.class)).toList();
    }

    @Override
    public InventoryDTO getInventory(String itemCode) {
        return modelMapper.map(inventoryRepo.findById(itemCode).get(), InventoryDTO.class);
    }

    @Override
    public boolean updateInventory(InventoryDTO inventoryDTO, MultipartFile file) throws IOException {
        Inventory inventory = inventoryRepo.findById(inventoryDTO.getItemCode()).get();
        inventory.setSupplier(supplierRepo.findById(inventoryDTO.getSupplierId()).get());
        inventory.setSupplierName(inventory.getSupplier().getSupplierName());
        inventory.setSize(inventoryDTO.getSize());
        inventory.setQtyOnHand(inventoryDTO.getQtyOnHand());
        inventory.setSellingPrice(inventoryDTO.getSellingPrice());
        inventory.setItemDescription(inventoryDTO.getItemDescription());
        inventory.setItemGender(inventoryDTO.getItemGender());
        inventory.setItemType(inventoryDTO.getItemType());
        inventory.setBrand(inventoryDTO.getBrand());
        inventory.setBuyingPrice(inventoryDTO.getBuyingPrice());
        inventory.setDiscount(inventoryDTO.getDiscount());
        inventory.setExpectedProfit(inventoryDTO.getExpectedProfit());
        inventory.setProfitMargin(inventoryDTO.getProfitMargin());
        inventory.setItemStatus(inventoryDTO.getItemStatus());
        inventory.setGetStockTotal(inventoryDTO.getQtyOnHand());
        if (!file.getOriginalFilename().equals("notUpdate")) {
            String image = uploadService.uploadFile(file);
            inventory.setItemPicture(image);
        }
        inventoryRepo.save(inventory);
        return true;
    }

    @Override
    public List<String> getBrands() {
        return inventoryRepo.getBrands();
    }

    @Override
    public List<InventoryDTO> getAvailableBrandItems(String brand) {
        return inventoryRepo.findAllByBrandAndItemStatusNot(brand, ItemStatus.NOT_AVAILABLE).stream().map(inventory -> modelMapper.map(inventory, InventoryDTO.class)).toList();
    }
}
