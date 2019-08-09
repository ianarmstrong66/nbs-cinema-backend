package com.lunacinemas.restfulapi;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lunacinemas.businesslogic.SendEmail;
import com.lunacinemas.model.LunaEmail;

@RestController
@CrossOrigin()
public class EmailController { 

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendEmail(@RequestBody LunaEmail lunaEmail) throws MessagingException {
        return SendEmail.sendEmail(lunaEmail);
    }

}