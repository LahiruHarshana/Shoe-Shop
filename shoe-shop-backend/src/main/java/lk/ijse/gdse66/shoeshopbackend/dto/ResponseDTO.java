package lk.ijse.gdse66.shoeshopbackend.dto;

import lk.ijse.gdse66.shoeshopbackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author : L.H.J
 * @File: ResponseDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable {
    private String message;
    private int status;
    private HashMap<String, Object> data = new HashMap<>();

    public ResponseDTO(String message, int status) {
        this.message = message;
        this.status = status;
    }

}
