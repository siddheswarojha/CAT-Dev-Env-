package com.cat.cat.Services;


import com.cat.cat.Model.ParcelData;
import com.cat.cat.Model.User;
import com.cat.cat.Repository.UserRepository;
import com.cat.cat.View.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationServices {


    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        Optional<User> userOptional = userRepository.findUserByEmailAddress(user.getEmailAddress());

        if(userOptional.isPresent())
        {
            return "Email Address already in use";

        }

        else if(user.getEmailAddress()==null || user.getName()==null|| user.getPassword()==null)
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

            user.setApiKey(key);
            userRepository.save(user);
            return "Registered";
        }

    }

    public String login(Login login) {

        User user = userRepository.findUserByEmailAddress(login.getEmailAddress())
                .orElseThrow(() -> new IllegalStateException("User Not Found!"));


        if (login.getPassword().equals(user.getPassword()))
            return user.getApiKey();
        return "error";
    }
}
