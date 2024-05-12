package lk.ijse.gdse66.shoeshopbackend.dto;

import lk.ijse.gdse66.shoeshopbackend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : L.H.J
 * @File: userDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userName;
    private String profilePic;
    private Role role;
}
