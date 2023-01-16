package com.example.trail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
//@CompoundIndexes()
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    int id;
    String userName;
    String fullName;
    ContactInfo contactInfo;

    /*public User() {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public List<ContactInfo> getList() {
        return list;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setList(List<ContactInfo> list) {
        this.list = list;
    }
/*
    String email;
    String address;
    String ph;
    String org;*/
}
