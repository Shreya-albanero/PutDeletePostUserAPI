package com.example.trail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "contactDb")
public class ContactInfo {
    String email;
    @Email
    String address;
    @Size(min=10, max=10, message = "Invalid phone number")
    String ph;
    //int Uid;

}
