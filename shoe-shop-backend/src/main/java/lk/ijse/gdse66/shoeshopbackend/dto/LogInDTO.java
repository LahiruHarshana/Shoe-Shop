package lk.ijse.gdse66.shoeshopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInDTO implements Serializable {
    private String username;
    private String password;
}
