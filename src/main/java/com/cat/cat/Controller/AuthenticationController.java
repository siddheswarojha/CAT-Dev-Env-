package com.cat.cat.Controller;


import com.cat.cat.Model.User;
import com.cat.cat.Services.AuthenticationServices;
import com.cat.cat.View.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("api/v1/cat/auth")
public class AuthenticationController {


    @Autowired
    private AuthenticationServices authServices;



    @PostMapping("/userSignUp")
    public String signUp( @RequestBody User user)
    {

        return authServices.register(user);

    }

    @PostMapping("/login")
    public String login( @RequestBody Login login)
    {

        return authServices.login(login);

    }
}
