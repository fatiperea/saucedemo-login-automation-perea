package com.epam.training.perea_fatima.saucedemo.services;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class TestDataReader {

    private static ResourceBundle resourceBundle= ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getValidPassword(){ return resourceBundle.getString("valid.password"); };

    public static List<String> getAllValidUser(){ return Arrays.asList(resourceBundle.getString("valid.users").split(","));
    };




}
