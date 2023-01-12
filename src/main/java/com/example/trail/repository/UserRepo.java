package com.example.trail.repository;

import com.example.trail.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, Integer> {
}
