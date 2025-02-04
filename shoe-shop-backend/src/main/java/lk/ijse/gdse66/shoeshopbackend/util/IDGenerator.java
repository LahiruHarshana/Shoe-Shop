package lk.ijse.gdse66.shoeshopbackend.util;

import lk.ijse.gdse66.shoeshopbackend.enums.ItemGender;
import lk.ijse.gdse66.shoeshopbackend.enums.ItemType;

import java.util.UUID;

/**
 * @author : L.H.J
 * @File: IDGenerator
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
public class IDGenerator {
    public static String generateBranchId() {
        String uuid = UUID.randomUUID().toString();
        return "BRAC-"+uuid.substring(0, 8);
    }

    public static String generateSupplierId() {
        String uuid = UUID.randomUUID().toString();
        return "SUP-"+uuid.substring(0, 8);
    }

    public static String generateEmployeeId() {
        String uuid = UUID.randomUUID().toString();
        return "EMP-"+uuid.substring(0, 8);
    }

    public static String generateItemCode(ItemGender itemGender, ItemType itemType, String itemDescription) {
        String uuid = UUID.randomUUID().toString();
        return String.format("%s%s%s-%s",itemType.toString().charAt(0),"S", itemGender.toString().charAt(0), uuid.substring(0, 6));
    }

    public static String generateCustomerId() {
        String uuid = UUID.randomUUID().toString();
        return "CUS-"+uuid.substring(0, 6);
    }

    public static String generateSaleId() {
        String uuid = UUID.randomUUID().toString();
        return "SAL-"+uuid.substring(0, 6);
    }
}
