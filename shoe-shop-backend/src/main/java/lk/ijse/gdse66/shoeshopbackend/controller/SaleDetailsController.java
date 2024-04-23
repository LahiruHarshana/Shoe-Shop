package lk.ijse.gdse66.shoeshopbackend.controller;

import lk.ijse.gdse66.shoeshopbackend.dto.CustomerDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.ResponseDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SaleDetailsDTO;
import lk.ijse.gdse66.shoeshopbackend.service.CustomerService;
import lk.ijse.gdse66.shoeshopbackend.service.SaleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author : L.H.J
 * @File: SaleDetailsController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@RestController
@RequestMapping("/api/v1/saleDetails")
public class SaleDetailsController {
    @Autowired
    SaleDetailsService saleDetailsService;

    @PostMapping
    public ResponseDTO saveSaleDetailsService(@RequestBody SaleDetailsDTO saleDetailsDTO){
        try {
            System.out.println("SaleDetailsService save"+ saleDetailsDTO);
            return new ResponseDTO("SaleDetailsService saved successfully", saleDetailsService.saveSaleDetails(saleDetailsDTO));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/dis/{id}")
    public ResponseDTO disableSaleDetailsService(@PathVariable String id) {
        try {
            return new ResponseDTO("SaleDetailsService disabled successfully", saleDetailsService.disable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/enb/{id}")
    public ResponseDTO enableSaleDetailsService(@PathVariable String id) {
        try {
            return new ResponseDTO("SaleDetailsService enabled successfully", saleDetailsService.enable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @GetMapping
    public List<SaleDetailsDTO> getAllSaleDetailsService() {
        List<SaleDetailsDTO> saleDetailsDTOS = saleDetailsService.findAllSaleDetails();
        if (!saleDetailsDTOS.isEmpty()) {
            return saleDetailsDTOS;
        } else {
            return null;
        }
    }
    @GetMapping("/{type}/{value}")
    public ResponseDTO getSelectedSaleDetailsService(@PathVariable String type, @PathVariable String value) {
        return null;
    }

    @PostMapping("/pagination")
    public ResponseDTO getAllSaleDetailsService(@RequestBody PaginationDTO paginationDTO) {
        try {
            HashMap<String, Object> map = new HashMap<>();
            if (paginationDTO == null) {
                map.put("SaleDetailsService", saleDetailsService.findAllSaleDetails());
            }else {
                map.put("SaleDetailsService", saleDetailsService.paginationSaleDetails(paginationDTO));
            }
            return new ResponseDTO("SaleDetailsService found successfully",200, map);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }
}
