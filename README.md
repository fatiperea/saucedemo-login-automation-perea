# Selenium Automation Project

## Overview

This project implements an **automated login test** for a sample web application: [SauceDemo](https://www.saucedemo.com/) 

## Use Cases
- **UC‑1**: Login with empty credentials → message "Username is required".
- **UC‑2**: Login with username but no password → message "Password is required".
- **UC‑3**: Valid login → title "Swag Labs".

Automated testing project using:

- Programming Language: Java
- Test Automation tool: Selenium WebDriver;
- Project Builder: Maven;
- Browsers: 1) Edge; 2) Chrome;
- Locators: XPath;
- Test Runner: JUnit;
- Logger: Log4j
  
 goal is to validate the basic authentication flow: entering a username and password, clicking the **Login** button, and verifying successful access.

## Setup
Clone the repository:
```bash
git clone <repo-url>
 ```

## 🚀 Run Tests
You can run the tests directly from your IDE or using Maven’s test lifecycle.

## 📝 Notes
- All dependencies are defined in `pom.xml`.   
- The login flow is a basic example and can be extended to more complex scenarios.

