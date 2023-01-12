package com.example.trail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    int id;
    String userName;
    String fullName;
    String email;
    String address;
    String ph;
    String org;
}
