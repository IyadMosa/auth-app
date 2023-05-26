package com.img.authapp.security;

import com.img.authapp.details.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Address address;

}
