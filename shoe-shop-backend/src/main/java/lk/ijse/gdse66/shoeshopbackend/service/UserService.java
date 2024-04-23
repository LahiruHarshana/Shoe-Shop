package lk.ijse.gdse66.shoeshopbackend.service;


import lk.ijse.gdse66.shoeshopbackend.dto.UserDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.UserPasswordDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(String id);
    User changePassword(String id, UserPasswordDTO userPasswordDTO);
    public Integer updateUser(UserDTO userDTO);
    Integer saveUser(UserDTO userDTO);
}
