package com.cat.cat.Model;


import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Document(collection = "user")
@Component
public class User {

    @Id
    ObjectId _id;
    String apiKey;
    String name;
    String password;
    String emailAddress;

    public User(){}

    public User(String apiKey, String name, String password, String emailAddress) {
        this.apiKey = apiKey;
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
    }



}
