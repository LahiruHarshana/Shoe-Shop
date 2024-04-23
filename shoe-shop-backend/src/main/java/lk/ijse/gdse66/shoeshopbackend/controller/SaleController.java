package lk.ijse.gdse66.shoeshopbackend.controller;

import lk.ijse.gdse66.shoeshopbackend.dto.InventoryDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.ResponseDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SaleDTO;
import lk.ijse.gdse66.shoeshopbackend.service.InventoryService;
import lk.ijse.gdse66.shoeshopbackend.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author : L.H.J
 * @File: SaleController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@RestController
@RequestMapping("/api/v1/sale")
public class SaleController {
    @Autowired
    SaleService saleService;

    @PostMapping
    public ResponseDTO saveSale(@RequestBody SaleDTO saleDTO){
        try {
            System.out.println("Sale save"+saleDTO);
            return new ResponseDTO("Sale saved successfully", saleService.saveSale(saleDTO));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/dis/{id}")
    public ResponseDTO disableSale(@PathVariable String id) {
        try {
            return new ResponseDTO("Sale disabled successfully", saleService.disable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/enb/{id}")
    public ResponseDTO enabledSale(@PathVariable String id) {
        try {
            return new ResponseDTO("Sale enabled successfully", saleService.enable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }
    @GetMapping("/{type}/{value}")
    public ResponseDTO getSelectSale(@PathVariable String type, @PathVariable String value) {
        return null;
    }

    @PostMapping("/pagination")
    public ResponseDTO getAllSale(@RequestBody PaginationDTO paginationDTO) {
        try {
            HashMap<String, Object> map = new HashMap<>();
            if (paginationDTO == null) {
                map.put("Sale", saleService.findAllSale());
            }else {
                map.put("Sale", saleService.paginationSale(paginationDTO));
            }
            return new ResponseDTO("Sale found successfully",200, map);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @GetMapping
    public List<SaleDTO> getAllSale() {
        List<SaleDTO> saleDTOS = saleService.findAllSale();
        if (!saleDTOS.isEmpty()) {
            return saleDTOS;
        } else {
            return null;
        }
    }
}
