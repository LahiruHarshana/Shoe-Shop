package lk.ijse.gdse66.shoeshopbackend.dto;

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
    private String userId;
//    private String employeeCode;
    private String username;
    private String email;
    private String password;
    private UserRole role;
    private String createBy;
    private String modifyBy;
    private boolean isActive;

    public enum UserRole {
        ADMIN, USER
    }
}
