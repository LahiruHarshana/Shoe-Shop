package lk.ijse.gdse66.shoeshopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Dewmith Mihisara
 * @date 2024-04-17
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO implements Serializable {
    private Integer offset;
    private Integer limit;
    private String columnName;
}
