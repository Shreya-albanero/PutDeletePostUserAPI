package com.example.trail.controller;

import com.example.trail.entity.ContactInfo;
import com.example.trail.entity.User;
import com.example.trail.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;

@ExtendWith(MockitoExtension.class)
public class TestControllerV2 {
    @Mock
    private UserRepo uRepo;

    @Test
    public void savedUser() {
        User user = new User();
        user.setUserName("ramu");
        user.setFullName("ramu gupta");
        user.setContactInfo(new ContactInfo("rg", "21 add", "585811"));

      //  when(uRepo.count(uRepo.getUserName())).thenReturn(1L);
        //assertThat(isSaveSuccess).isEqualTo(false);
    }
}
