package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.SaleDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Customer;
import lk.ijse.gdse66.shoeshopbackend.entity.Inventory;
import lk.ijse.gdse66.shoeshopbackend.entity.Sale;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemStatus;
import lk.ijse.gdse66.shoeshopbackend.enums.Level;
import lk.ijse.gdse66.shoeshopbackend.repo.CustomerRepo;
import lk.ijse.gdse66.shoeshopbackend.repo.InventoryRepo;
import lk.ijse.gdse66.shoeshopbackend.repo.SaleRepo;
import lk.ijse.gdse66.shoeshopbackend.repo.UserRepo;
import lk.ijse.gdse66.shoeshopbackend.service.SaleService;
import lk.ijse.gdse66.shoeshopbackend.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : L.H.J
 * @File: SaleServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepo saleRepo;
    private final ModelMapper mapper;
    private final InventoryRepo inventoryRepo;
    private final CustomerRepo customerRepo;
    private final UserRepo userRepo;

    @Override
    @Transactional
    public boolean saveSale(SaleDTO saleDTO) {
        List<Inventory> inventories = new ArrayList<>();
        Sale sale = mapper.map(saleDTO, Sale.class);
        saleDTO.getInventories().forEach(inventory -> inventoryRepo.findById(inventory.getItemCode()).ifPresent(entity -> {
            entity.setQtyOnHand(entity.getQtyOnHand() - inventory.getGetqty());
            entity.setItemSoldCount(entity.getItemSoldCount() + inventory.getGetqty());
            Integer getStockTotal = entity.getGetStockTotal();
            int percentageInStock = (entity.getQtyOnHand() * 100) / getStockTotal;
            if (percentageInStock <= 50 && entity.getQtyOnHand() >= 1) {
                entity.setItemStatus(ItemStatus.LOW_STOCK);
            } else if (entity.getQtyOnHand() == 0) {
                entity.setItemStatus(ItemStatus.NOT_AVAILABLE);
            }
            inventories.add(inventoryRepo.save(entity));
        }));
        sale.setSaleId(IDGenerator.generateSaleId());
        //sale.setSaleInventories(inventories);
        sale.setUser(userRepo.findById(saleDTO.getCashierName()).get());
        sale.setSubTotal(saleDTO.getSubTotal());
        if (!saleDTO.getIsDemo()) {
            Customer customer = customerRepo.findCustomerByContact(saleDTO.getCustomerContact());
            customer.setTotalPoints(customer.getTotalPoints() == null ? saleDTO.getAddedPoints() : customer.getTotalPoints() + saleDTO.getAddedPoints());
            int totalPoints = customer.getTotalPoints() + saleDTO.getAddedPoints();
            if (totalPoints < 50) {
                customer.setLevel(Level.NEW);
            } else if (totalPoints < 100) {
                customer.setLevel(Level.BRONZE);
            } else if (totalPoints < 200) {
                customer.setLevel(Level.SILVER);
            } else {
                customer.setLevel(Level.GOLD);
            }
            customer.setRecentPurchaseDate(new Date(System.currentTimeMillis()));
            sale.setCustomer(customerRepo.save(customer));
        } else {
            sale.setCustomer(null);
        }
        saleRepo.save(sale);
        return true;
    }
}
