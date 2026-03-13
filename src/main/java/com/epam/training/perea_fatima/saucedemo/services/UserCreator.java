package com.epam.training.perea_fatima.saucedemo.services;

import com.epam.training.perea_fatima.saucedemo.models.User;

import java.util.List;
import java.util.stream.Stream;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "valid.user";
    public static final String TESTDATA_USER_PASSWORD = "valid.password";

    public static User emptyCredentials(){

        return new User("", "");
    }

    public static User emptyPassword(String username){

        return new User(username,"");

    }

    public static Stream<User> validUsers(){

        String password=TestDataReader.getValidPassword();

        List<String> usernames= TestDataReader.getAllValidUser();

        return usernames.stream().map(user -> new User(user, password));
    }

    public static User validUser(){

        String password=TestDataReader.getValidPassword();
        String username=TestDataReader.getAllValidUser().get(0);

        return new User(username, password);

    }

}
