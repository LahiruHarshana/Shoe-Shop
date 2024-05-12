package lk.ijse.gdse66.shoeshopbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.gdse66.shoeshopbackend.embedded.Address;
import lk.ijse.gdse66.shoeshopbackend.enums.Gender;
import lk.ijse.gdse66.shoeshopbackend.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author : L.H.J
 * @File: CustomerDTO
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-04-21, Sunday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO{
    private String userEmail;
    private String customerId;
    private String customerName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Gender gender;
    private Integer totalPoints;
    private String contact;
    private String email;
    private java.sql.Date recentPurchaseDate;
    private Address address;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Level level;
    private Date dob;
    private Timestamp registeredDate;
}
