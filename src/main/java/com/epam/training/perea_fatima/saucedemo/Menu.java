package com.epam.training.perea_fatima.saucedemo;

import java.util.Scanner;

public class Menu {

    /*public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the SauceDemo Test Automation");
        System.out.println("Please select a test to run:");
        System.out.println("0. Driver Factory Test");
        System.out.println("1. Login Test");
        System.out.println("2. Main page Test");
        System.out.println("3. Login Test with User");
        System.out.println("4. Main page Test with User");

        int option = scanner.nextInt();

        switch (option) {
            case 0:
                DriverFactoryTest.class;
                break;
            case 1:
                //LoginPageTest.main(null);
                break;
            case 2:
                //MainPageTest.main(null);
                break;
            case 3:
                //LoginPageTestWithUser.main(null);
                break;
            case 4:
                //MainPageTestWithUser.main(null);
                break;
            default:

                System.out.println("Invalid option. Please select a number between 0 and 4.");
        }





    }*/

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el test:");
        System.out.println("1. LoginTest");
        System.out.println("2. DriverFactoryTest");

        int opcion = sc.nextInt();

        String testClass = switch (opcion) {
            case 1 -> "LoginTest";
            case 2 -> "DriverFactoryTest";
            default -> null;
        };

        if (testClass != null) {
            // Ejecuta Maven con el test indicado
            ProcessBuilder pb = new ProcessBuilder(
                    "mvn", "test", "-Dtest=" + testClass
            );
            pb.inheritIO(); // muestra salida en consola
            Process p = pb.start();
            p.waitFor();
        } else {
            System.out.println("Opción inválida");
        }
    }

}
