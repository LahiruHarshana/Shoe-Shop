package lk.ijse.gdse66.shoeshopbackend.controller;

import lk.ijse.gdse66.shoeshopbackend.dto.CustomerDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.ResponseDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.UserDTO;
import lk.ijse.gdse66.shoeshopbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author : L.H.J
 * @File: CustomerController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        try {
            System.out.println("Customer save"+customerDTO);
            return new ResponseDTO("Customer saved successfully", customerService.saveCustomer(customerDTO));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/dis/{id}")
    public ResponseDTO disableCustomer(@PathVariable String id) {
        try {
            return new ResponseDTO("Customer disabled successfully", customerService.disable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/enb/{id}")
    public ResponseDTO enablesCustomer(@PathVariable String id) {
        try {
            return new ResponseDTO("Customer enabled successfully", customerService.enable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOS = customerService.findAllCustomers();
        if (!customerDTOS.isEmpty()) {
            return customerDTOS;
        } else {
            return null;
        }
    }
    @GetMapping("/{type}/{value}")
    public ResponseDTO getSelectedCustomer(@PathVariable String type, @PathVariable String value) {
        return null;
    }

    @PostMapping("/pagination")
    public ResponseDTO getAllCustomers(@RequestBody PaginationDTO paginationDTO) {
        try {
            HashMap<String, Object> map = new HashMap<>();
            if (paginationDTO == null) {
                map.put("customers", customerService.findAllCustomers());
            }else {
                map.put("customer", customerService.paginationCustomers(paginationDTO));
            }
            return new ResponseDTO("Customers found successfully",200, map);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }
}
