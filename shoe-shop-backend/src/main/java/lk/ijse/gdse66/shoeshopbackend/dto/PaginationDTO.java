package lk.ijse.gdse66.shoeshopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : L.H.J
 * @File: PaginationDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO implements Serializable {
    private Integer offset;
    private Integer limit;
    private String columnName;
}
