package lk.ijse.gdse66.shoeshopbackend.dto;

import lk.ijse.gdse66.shoeshopbackend.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

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
    private String customerCode;
    private String customerName;
    private String userId;
    private Gender gender;
    private Date joinDate;
    private LoyaltyLevel level;
    private Integer totalPoints;
    private Date dob;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private Date recentPurchaseDateTime;
    private String createBy;
    private String modifyBy;
    private boolean isActive;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public enum LoyaltyLevel {
        GOLD, SILVER, BRONZE, NEW
    }
}
