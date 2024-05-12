package lk.ijse.gdse66.shoeshopbackend.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : L.H.J
 * @File: Contact
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Contact {
    private String mobile;
    private String land;
}
