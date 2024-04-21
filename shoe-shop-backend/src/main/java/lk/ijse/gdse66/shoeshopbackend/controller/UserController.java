package lk.ijse.gdse66.shoeshopbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : L.H.J
 * @File: UserController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @PostMapping
    public void saveUser(){
        System.out.println("User saved");
    }

    @GetMapping
    public void getUser(){
        System.out.println("User get");
    }

}
