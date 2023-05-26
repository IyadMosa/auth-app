package com.img.authapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.img.authapp.details.Address;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date joinAt;
    private int points;
    @Embedded
    @NotNull
    private Address address;

}
