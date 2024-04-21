package lk.ijse.gdse66.shoeshopbackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : L.H.J
 * @File: CustomerController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @PostMapping
    public void saveCustomer(){
        System.out.println("Customer saved");
    }



}
