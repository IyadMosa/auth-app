package com.img.authapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.img.authapp.details.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date joinAt;
    private int points;
    private Address address;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
