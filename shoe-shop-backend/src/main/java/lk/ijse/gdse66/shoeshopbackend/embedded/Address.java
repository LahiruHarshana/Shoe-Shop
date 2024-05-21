package lk.ijse.gdse66.shoeshopbackend.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author : L.H.J
 * @File: Address
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String lane;
    private String mainCountry;
    private String mainCity;
    private String mainState;
    private String postalCode;
}
