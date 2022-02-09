package com.cat.cat.Services;


import com.cat.cat.Model.User;
import com.cat.cat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationServices {


    @Autowired
    private UserRepository userRepository;

    public String register(Map<String, String> user) {
        Optional<User> userOptional = userRepository.findUserByEmailAddress(user.get("emailAddress"));

        if(userOptional.isPresent())
        {
            return "Email Address already in use";

        }

        else if(user.get("emailAddress")==null || user.get("name")==null|| user.get("password")==null)
        {
            return "Bad Body Found";
        }
        else
        {

            String key =UUID.randomUUID().toString();
//            Optional<User> apiKey = userRepository.findUserByApiKey(key);
//
//            if(apiKey.isPresent())
//            {
//
//            }

            User userObj = new User();

            userObj.setApiKey(key);
            userObj.setEmailAddress(user.get("emailAddress"));
            userObj.setName(user.get("name"));
            userObj.setPassword(user.get("password"));
            userRepository.save(userObj);
            return "Registered";
        }

    }

    public String login(Map<String, String> login) {

        User user = userRepository.findUserByEmailAddress(login.get("emailAddress"))
                .orElseThrow(() -> new IllegalStateException("User Not Found!"));


        if (login.get("password").equals(user.getPassword()))
        {
            return user.getApiKey();
        }
        else
        {
            return "Wrong Password";
        }

    }
}
