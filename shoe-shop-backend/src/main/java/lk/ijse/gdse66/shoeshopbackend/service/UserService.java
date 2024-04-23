package lk.ijse.gdse66.shoeshopbackend.service;


import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.UserDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.UserPasswordDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.User;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public Integer saveUser(UserDTO userDTO);
    public Integer disable(String id);
    public Integer updateUser(UserDTO userDTO);
    public List<UserDTO> findAllUsers();
    public Integer enable(String id);
    public List<UserDTO> paginationUsers(PaginationDTO paginationDTO);
}
