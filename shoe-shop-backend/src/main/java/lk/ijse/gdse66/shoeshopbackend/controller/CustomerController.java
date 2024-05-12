package lk.ijse.gdse66.shoeshopbackend.controller;

import lk.ijse.gdse66.shoeshopbackend.dto.CustomerDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.ResponseDTO;
import lk.ijse.gdse66.shoeshopbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "*")
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

    @PutMapping
    public ResponseDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        try {
            return new ResponseDTO("Customer updated successfully", customerService.updateCustomer(customerDTO));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/dis/{id}")
    public ResponseDTO disableCustomer(@PathVariable String id) {
        try {
            return new ResponseDTO("Customer disabled successfully", customerService.disable(Long.valueOf(id)));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/enb/{id}")
    public ResponseDTO enablesCustomer(@PathVariable String id) {
        try {
            return new ResponseDTO("Customer enabled successfully", customerService.enable(Long.valueOf(id)));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable String customerId) {
        try {
            CustomerDTO customer = customerService.findCustomerById(Long.valueOf(customerId));
            if (customer != null) {
                return ResponseEntity.ok().body(customer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
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
