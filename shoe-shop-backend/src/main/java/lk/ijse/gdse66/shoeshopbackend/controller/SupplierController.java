package lk.ijse.gdse66.shoeshopbackend.controller;

import lk.ijse.gdse66.shoeshopbackend.dto.CustomerDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.ResponseDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.SupplierDTO;
import lk.ijse.gdse66.shoeshopbackend.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author : L.H.J
 * @File: SupplierController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/

@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping
    public ResponseDTO saveSupplier(@RequestBody SupplierDTO supplierDTO){
        try {
            System.out.println("Supplier save"+supplierDTO);
            return new ResponseDTO("Supplier saved successfully", supplierService.saveSupplier(supplierDTO));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/dis/{id}")
    public ResponseDTO disabledSupplier(@PathVariable String id) {
        try {
            return new ResponseDTO("Supplier disabled successfully", supplierService.disable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/enb/{id}")
    public ResponseDTO enabledSupplier(@PathVariable String id) {
        try {
            return new ResponseDTO("Supplier enabled successfully", supplierService.enable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }
    @GetMapping("/{type}/{value}")
    public ResponseDTO getSelectSupplier(@PathVariable String type, @PathVariable String value) {
        return null;
    }

    @PostMapping("/pagination")
    public ResponseDTO getAllSuppliers(@RequestBody PaginationDTO paginationDTO) {
        try {
            HashMap<String, Object> map = new HashMap<>();
            if (paginationDTO == null) {
                map.put("supplier", supplierService.findAllSupplier());
            }else {
                map.put("supplier", supplierService.paginationSupplier(paginationDTO));
            }
            return new ResponseDTO("Supplier found successfully",200, map);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }
}
