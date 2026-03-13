package com.epam.training.perea_fatima.saucedemo.services;

import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TestDataReader {

    private static ResourceBundle resourceBundle;//= ResourceBundle.getBundle(System.getProperty("dev"));

    static {
        String env = System.getProperty("environment", "dev"); // default a dev
        try {
            resourceBundle = ResourceBundle.getBundle(env);
        } catch (MissingResourceException e) {
            throw new IllegalStateException("No se encontró " + env + ".properties en el classpath", e);
        }
    }

    public static String getValidPassword(){ return resourceBundle.getString("valid.password"); };

    public static List<String> getAllValidUser(){ return Arrays.asList(resourceBundle.getString("valid.users").split(","));
    };




}
