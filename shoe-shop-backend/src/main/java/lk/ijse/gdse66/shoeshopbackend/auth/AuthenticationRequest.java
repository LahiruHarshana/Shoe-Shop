package lk.ijse.gdse66.shoeshopbackend.auth;

import lombok.Data;

import java.io.Serializable;
@Data
public class AuthenticationRequest implements Serializable {
    private String username;
    private String password;
}
