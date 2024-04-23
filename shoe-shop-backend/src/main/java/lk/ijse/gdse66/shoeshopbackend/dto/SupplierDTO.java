package lk.ijse.gdse66.shoeshopbackend.dto;

/**
 * @author : L.H.J
 * @File: SupplierDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private String supplierCode;
    private String supplierName;
    private SupplierCategory category;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String addressLine6;
    private String contactNo1;
    private String contactNo2;
    private String email;
    public enum SupplierCategory {
        INTERNATIONAL, LOCAL
    }
}
