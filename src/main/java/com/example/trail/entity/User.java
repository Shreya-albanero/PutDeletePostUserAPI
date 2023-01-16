package com.example.trail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
//@CompoundIndexes()
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    int id;
    @NotBlank
    String userName;
    String fullName;
    ContactInfo contactInfo;

}
