package com.example.trail.controller;

import com.example.trail.entity.ContactInfo;
import com.example.trail.entity.User;
import com.example.trail.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {
   @MockBean
    UserRepo userRepo;
    @MockBean
    UserController userController;
    @Autowired
    MockMvc mockMvc;
    @Test
    public void testNotValidAddUser() throws Exception{
        /*User user = new User();
        user.setId(161);
        user.setUserName("");
        user.setFullName("ram gupta");
        user.setContactInfo(new ContactInfo("rg", "21 add", "5858110000"));*/

       // when(userController.addUser(any(User.class)).thenReturn(ResponseEntity.ok("saved"));
        String user="{\n" +
                "    \"id\": 161,\n" +
                "    \"userName\": \"\",\n" +
                "    \"fullName\": \"ramu gupta\",\n" +
                "    \"contactInfo\": {\n" +
                "        \"email\": \"rg\",\n" +
                "        \"address\": \"21 add\",\n" +
                "        \"ph\": \"585811\"\n" +
                "    }\n" +
                "}";

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/addUser")
                                .content(user)
                                //.content(asJsonString(user))
                                .contentType(APPLICATION_JSON)
                                .accept(APPLICATION_JSON)

                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
               // .andExpect(status().reason())
                .andExpect(content().string(""));

    }
    /*@Test
    public void testValidAddUser() throws Exception{
        //MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String user = "{\n" +
                "    \"id\": 161,\n" +
                "    \"userName\": \"shreya\",\n" +
                "    \"fullName\": \"ramu gupta\",\n" +
                "    \"contactInfo\": {\n" +
                "        \"email\": \"rg\",\n" +
                "        \"address\": \"21 add\",\n" +
                "        \"ph\": \"585811\"\n" +
                "    }\n" +
                "}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/addUser")
                        .content(user)
                        .contentType(APPLICATION_JSON)
                        //.accept(MediaType.APPLICATION_JSON)
    )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(APPLICATION_JSON));
    }*/

}
