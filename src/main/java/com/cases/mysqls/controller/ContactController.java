package com.cases.mysqls.controller;

import com.cases.mysqls.bean.EmailContactInfo;
import com.cases.mysqls.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ContactController {
   @Autowired
   EmailService emailService;
    @GetMapping(value="/new/email/{emailaddress}")
    public String newEmail(@PathVariable String emailaddress){
        System.out.println("startmeail");
        EmailContactInfo email = new EmailContactInfo();
        email.setEmailAddress(emailaddress);
        email.setFirstName("wesley");
        email.setLastName("wei");
        email.setCreatedOn(new Date());

        emailService.save(email);
        return "email insert ok";
    }

}
