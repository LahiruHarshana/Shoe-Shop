package lk.ijse.gdse66.shoeshopbackend.dto;

/**
 * @author : L.H.J
 * @File: SupplierDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-23, Tuesday
 **/
import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.gdse66.shoeshopbackend.embedded.Address;
import lk.ijse.gdse66.shoeshopbackend.embedded.Contact;
import lk.ijse.gdse66.shoeshopbackend.enums.SupplierCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private String supplierCode;
    private String supplierName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private SupplierCategory supplierCategory;
    private Contact contact;
    private String email;
    private Boolean isActive;
    private Address address;
    private String originCountry;
}
