package lk.ijse.gdse66.shoeshopbackend.auth;


import lk.ijse.gdse66.shoeshopbackend.enums.Role;

import java.io.Serializable;

public record AuthenticationResponse(String jwt, String username, String profilePic, Role role) implements Serializable {
}
