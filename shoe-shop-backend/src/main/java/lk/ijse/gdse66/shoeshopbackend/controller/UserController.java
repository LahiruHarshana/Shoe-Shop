package lk.ijse.gdse66.shoeshopbackend.controller;

import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.ResponseDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.UserDTO;
import lk.ijse.gdse66.shoeshopbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author : L.H.J
 * @File: UserController
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseDTO saveUser(@RequestBody UserDTO userDTO){
        try {
            System.out.println("User save"+userDTO);
            return new ResponseDTO("User saved successfully", userService.saveUser(userDTO));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/dis/{id}")
    public ResponseDTO disabledUser(@PathVariable String id) {
        try {
            return new ResponseDTO("User disabled successfully", userService.disable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/enb/{id}")
    public ResponseDTO enabledUser(@PathVariable String id) {
        try {
            return new ResponseDTO("User enabled successfully", userService.enable(id));
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }
    @GetMapping("/{type}/{value}")
    public ResponseDTO getSelectedUser(@PathVariable String type, @PathVariable String value) {
        return null;
    }

    @PostMapping("/pagination")
    public ResponseDTO getAllUsers(@RequestBody PaginationDTO paginationDTO) {

        System.out.println("paginationDTO = " + paginationDTO+"hello");
        try {
            HashMap<String, Object> map = new HashMap<>();
            if (paginationDTO == null) {
                map.put("users", userService.findAllUsers());
            }else {
                map.put("users", userService.paginationUsers(paginationDTO));
            }
            return new ResponseDTO("Users found successfully",200, map);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

}
