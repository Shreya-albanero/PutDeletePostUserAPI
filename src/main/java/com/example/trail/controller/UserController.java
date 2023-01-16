package com.example.trail.controller;

import com.example.trail.entity.User;
import com.example.trail.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
//import javax.validation.Valid;

//@Validated
@RestController
public class UserController {
    //@Autowired
    private UserRepo userRepo;

    @GetMapping("/getContactById/{id}")
    public String getContactById(@PathVariable int id) {
        String result;
         result=userRepo.findById(id).get().getContactInfo().getEmail();
         System.out.println(result);
        return result;

    }

    @PostMapping("/addUser")
    @ResponseBody
    public ResponseEntity<Object>  addUser(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()) {
            //return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().body("");
        }
        else {
            //userRepo.save(user);
            return ResponseEntity.ok("saved");
        }
    }
    @DeleteMapping("/{id}")
    public String userDelete( @PathVariable int id){
        userRepo.deleteById(id);
        return "deleted successfully";
    }

    @PutMapping("/editUser/{userName}")
        public User editName(@RequestBody User user, @PathVariable String userName){
            User u = new User();
            String s="";
            StringBuffer editName= new StringBuffer(user.getFullName());
            for(int i=0; i<editName.length(); i++){
                if(editName.charAt(i)=='a' ||editName.charAt(i) == 'e'|| editName.charAt(i) == 'i' || editName.charAt(i) == 'o' || editName.charAt(i) == 'u') {
                    s=s+"/";
                }
                else
                    s+=editName.charAt(i);
            }
            u.setFullName(s);
            System.out.println(s);
            return userRepo.save(u);
        }

}
