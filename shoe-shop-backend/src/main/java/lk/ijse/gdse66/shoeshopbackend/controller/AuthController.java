package lk.ijse.gdse66.shoeshopbackend.controller;

import lk.ijse.gdse66.shoeshopbackend.dto.LogInDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.User;
import lk.ijse.gdse66.shoeshopbackend.repository.UserRepository;
import lk.ijse.gdse66.shoeshopbackend.security.jwt.JwtUtil;
import lk.ijse.gdse66.shoeshopbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtils;
    @PostMapping("/auth/signin")
    public ResponseEntity<?> login(@RequestBody LogInDTO loginDTO) {
        System.out.println("hi halo");
        System.out.println("AuthController.login");
        System.out.println(loginDTO);
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(jwt);
    }
}
