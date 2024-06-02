package lk.ijse.gdse66.shoeshopbackend.util;

/**
 * @author : L.H.J
 * @File: DateChecker
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-06-01, Saturday
 **/
import lk.ijse.gdse66.shoeshopbackend.entity.Customer;
import lk.ijse.gdse66.shoeshopbackend.repo.CustomerRepo;
import lk.ijse.gdse66.shoeshopbackend.service.impl.EmailService;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class DateChecker {
    private final EmailService emailService;
    private final CustomerRepo customerRepo;

    @Autowired
    public DateChecker(CustomerRepo customerRepo, EmailService emailService) {
        System.out.println("DateChecker created");
        this.customerRepo = customerRepo;
        this.emailService = emailService;
        checkAndProcessBirthdays();
    }

    public void checkAndProcessBirthdays() {
        LocalDate today = LocalDate.now();
        List<Customer> allCustomers = customerRepo.findAll();

        for (Customer customer : allCustomers) {
            LocalDate dob = customer.getDob().toLocalDate();
            if (dob.getMonthValue() == today.getMonthValue() && dob.getDayOfMonth() == today.getDayOfMonth()) {
                sendBirthdayWish(customer);
            }
        }
    }

    private void sendBirthdayWish(Customer customer) {
        emailService.sendHtmlEmail(customer.getEmail(), "Happy Birthday", birthdayWishHtmlBody(customer, calculateAge(customer.getDob())));
    }

    public String birthdayWishHtmlBody(Customer customer, int age) {
        return "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Happy Birthday!</title>"
                + "<style>"
                + "body {"
                + "    font-family: 'Roboto', sans-serif;"
                + "    margin: 0;"
                + "    padding: 0;"
                + "    color: #333;"
                + "    background-color: #393E46;"
                + "}"
                + ".container {"
                + "    width: 100%;"
                + "    max-width: 600px;"
                + "    margin: 0 auto;"
                + "    background-color: #00ADB5;"
                + "    border-radius: 8px;"
                + "    overflow: hidden;"
                + "    padding: 20px;"
                + "    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);"
                + "}"
                + ".header {"
                + "    background-color: #007bff;"
                + "    color: white;"
                + "    padding: 20px;"
                + "    text-align: center;"
                + "    text-shadow: 0 0 10px rgba(0, 0, 0, 0.3);"
                + "    margin: 0 0 20px;"
                + "    border-radius: 8px 8px 0 0;"
                + "}"
                + ".header h1 {"
                + "    margin: 0;"
                + "    font-size: 24px;"
                + "}"
                + ".header img {"
                + "    max-width: 100px;"
                + "    margin-bottom: 10px;"
                + "}"
                + ".content {"
                + "    padding: 40px;"
                + "    margin: 0 0 20px;"
                + "}"
                + ".content p {"
                + "    line-height: 1.6;"
                + "    margin: 20px 0;"
                + "    font-size: 18px;"
                + "}"
                + ".button {"
                + "    display: inline-block;"
                + "    margin-top: 20px;"
                + "    padding: 10px 20px;"
                + "    background-color: #4CAF50;"
                + "    color: white;"
                + "    text-decoration: none;"
                + "    border-radius: 5px;"
                + "    border: none;"
                + "    transition: background-color 0.3s ease;"
                + "}"
                + ".button:hover {"
                + "    background-color: #45a049;"
                + "}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class=\"container\">"
                + "<div class=\"header\">"
                + "<img src=\"https://cdn1.vectorstock.com/i/1000x1000/59/95/shoe-shop-logo-concept-vector-24175995.jpg\" alt=\"Shoe Shop Logo\">"
                + "<h1>Happy Birthday, " + customer.getCustomerName() + "!</h1>"
                + "</div>"
                + "<div class=\"content\">"
                + "<p>We hope you have a fantastic birthday filled with joy, laughter, and wonderful surprises!</p>"
                + "<p>May this special day bring you lots of happiness and unforgettable memories.</p>"
                + "<p>You are now " + age + " years old!</p>"
                + "<a href='https://i.pinimg.com/736x/10/c5/84/10c584f8365b742abea2ac7b52540414.jpg' class='button'>Claim Your Birthday Gift</a>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
    }
    private int calculateAge(Date dob) {
        LocalDate birthDate = dob.toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
}

