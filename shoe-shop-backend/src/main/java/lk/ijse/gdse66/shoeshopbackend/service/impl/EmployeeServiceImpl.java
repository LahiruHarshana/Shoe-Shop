package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.EmployeeDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Branch;
import lk.ijse.gdse66.shoeshopbackend.entity.Employee;
import lk.ijse.gdse66.shoeshopbackend.entity.User;
import lk.ijse.gdse66.shoeshopbackend.enums.Role;
import lk.ijse.gdse66.shoeshopbackend.repo.BranchRepo;
import lk.ijse.gdse66.shoeshopbackend.repo.EmployeeRepo;
import lk.ijse.gdse66.shoeshopbackend.repo.UserRepo;
import lk.ijse.gdse66.shoeshopbackend.service.BranchService;
import lk.ijse.gdse66.shoeshopbackend.service.EmployeeService;
import lk.ijse.gdse66.shoeshopbackend.service.UploadService;
import lk.ijse.gdse66.shoeshopbackend.util.IDGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author : L.H.J
 * @File: EmployeeServiceImpl
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final UploadService uploadService;

    private final ModelMapper mapper;

    private final EmployeeRepo employeeRepo;

    private final BranchService branchService;

    private final UserRepo userRepo;

    private final EmailService emailService;
    private final PasswordEncoder bCryptPasswordEncoder;

    private final BranchRepo branchRepo;

    public EmployeeServiceImpl(UploadService uploadService, ModelMapper mapper, EmployeeRepo employeeRepo, BranchService branchService, UserRepo userRepo, PasswordEncoder bCryptPasswordEncoder, BranchRepo branchRepo, EmailService emailService) {
        this.uploadService = uploadService;
        this.mapper = mapper;
        this.employeeRepo = employeeRepo;
        this.branchService = branchService;
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.branchRepo = branchRepo;
        this.emailService = emailService;
    }

    @Transactional
    @Override
    public boolean saveEmployee(EmployeeDTO employee, MultipartFile file) throws IOException {
        String imageId = uploadService.uploadFile(file);
        Branch branch = branchService.getBranchById(employee.getBranchId());
        if (employee.getRole() == Role.ADMIN) {
            branch.setBranchManager(employee.getEmpName());
        }
        branch.setNoOfEmployees(branch.getNoOfEmployees() == null ? 1 : branch.getNoOfEmployees() + 1);
        branchRepo.save(branch);
        if (imageId == null) return false;
        Employee map = mapper.map(employee, Employee.class);
        map.setIsActive(true);
        map.setEmpId(IDGenerator.generateEmployeeId());
        map.setBranch(branch);
        map.setProfilePic(imageId);
        employeeRepo.save(map);

        User user = new User();
        String password = UUID.randomUUID().toString().substring(0, 8);
        System.out.println("password = " + password);
        emailService.sendHtmlEmail(employee.getEmail(), "Account Created", generateHtmlContent(employee.getEmpName(), employee.getEmail(), password));
        user.setUsername(employee.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRole(employee.getRole());
        user.setEmployee(map);
        userRepo.save(user);
        return true;
    }

    public String generateHtmlContent(String employeeName, String email, String password) {
        return "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Welcome to Shoe Shop</title>"
                + "<style>"
                + "body {"
                + "    font-family: 'Arial', sans-serif;"
                + "    background-color: #f7f7f7;"
                + "    margin: 0;"
                + "    padding: 0;"
                + "    color: #333;"
                + "}"
                + ".container {"
                + "    width: 100%;"
                + "    max-width: 600px;"
                + "    margin: 0 auto;"
                + "    background-color: #ffffff;"
                + "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);"
                + "    border-radius: 8px;"
                + "    overflow: hidden;"
                + "}"
                + ".header {"
                + "    background-color: #007bff;"
                + "    color: #ffffff;"
                + "    padding: 20px;"
                + "    text-align: center;"
                + "}"
                + ".header h1 {"
                + "    margin: 0;"
                + "    font-size: 24px;"
                + "}"
                + ".header img {"
                + "    max-width: 50px;"
                + "    margin-bottom: 10px;"
                + "}"
                + ".content {"
                + "    padding: 20px;"
                + "}"
                + ".content p {"
                + "    line-height: 1.6;"
                + "    margin: 15px 0;"
                + "}"
                + ".content .cta {"
                + "    display: block;"
                + "    width: fit-content;"
                + "    margin: 20px auto;"
                + "    padding: 10px 20px;"
                + "    background-color: #007bff;"
                + "    color: #ffffff;"
                + "    text-decoration: none;"
                + "    border-radius: 5px;"
                + "}"
                + ".footer {"
                + "    background-color: #f1f1f1;"
                + "    text-align: center;"
                + "    padding: 10px;"
                + "    font-size: 12px;"
                + "    color: #666666;"
                + "}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class=\"container\">"
                + "<div class=\"header\">"
                + "<img src=\"https://cdn1.vectorstock.com/i/1000x1000/59/95/shoe-shop-logo-concept-vector-24175995.jpg\" alt=\"Shoe Shop Logo\">"
                + "<h1>Welcome to Shoe Shop</h1>"
                + "</div>"
                + "<div class=\"content\">"
                + "<h2>Hello " + employeeName + ",</h2>"
                + "<p>We are thrilled to have you on board as part of our team at Shoe Shop!</p>"
                + "<p>Your account has been successfully created. Here are your account details:</p>"
                + "<p><strong>Username:</strong> " + email + "</p>"
                + "<p><strong>Password:</strong> " + password + "</p>"
                + "<p>Please keep this information safe and do not share it with anyone.</p>"
                + "<p>You can now log in to our system using the above credentials and start exploring your new workplace.</p>"
                + "<p>We are excited to see the contributions you'll bring to our team. Welcome aboard!</p>"
                + "<p>Best regards,<br>Shoe Shop Team</p>"
                + "</div>"
                + "<div class=\"footer\">"
                + "<p>&copy; 2024 Shoe Shop. All rights reserved.</p>"
                + "<p>Shoe Shop, 1234 Elm Street, City, State, ZIP</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
    }

    @Override
    public List<EmployeeDTO> getAllAdmins() {
        return employeeRepo.findAllByRole(Role.ADMIN).stream().map(employee -> mapper.map(employee, EmployeeDTO.class)).toList();
    }

    @Override
    public List<EmployeeDTO> getAllCashiers() {
        return employeeRepo.findAllByRole(Role.USER).stream().map(employee -> mapper.map(employee, EmployeeDTO.class)).toList();
    }

    @Override
    public EmployeeDTO getEmployee(String empId) {
        return mapper.map(employeeRepo.findById(empId).orElseThrow(), EmployeeDTO.class);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employeeDTO,MultipartFile file) throws IOException {
        Employee employee = employeeRepo.findById(employeeDTO.getEmpId()).orElseThrow();
        Branch branch = branchService.getBranchById(employeeDTO.getBranchId());
        employee.setBranch(branch);
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setAddress(employeeDTO.getAddress());
        employee.setContact(employeeDTO.getContact());
        employee.setRole(employeeDTO.getRole());
        employee.setEmergencyInfo(employeeDTO.getEmergencyInfo());
        employee.setEmergencyContact(employeeDTO.getEmergencyContact());
        employee.setDob(employeeDTO.getDob());
        employee.setGender(employeeDTO.getGender());
        employee.setAddress(employeeDTO.getAddress());
        if (!file.getOriginalFilename().equals("notUpdate")){
            String image = uploadService.uploadFile(file);
            employee.setProfilePic(image);
        }
        employeeRepo.save(employee);
        return true;
    }
}
