package com.hse.testing.hw03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public void login(String loginText, String passwordText) {
        String loginId = "id_l.L.login";
        String passwordId = "id_l.L.password";
        String loginButtonId = "id_l.L.loginButton";

        WebElement login = elementsById(loginId).get(0);
        WebElement password = elementsById(passwordId).get(0);
        WebElement loginButton = elementsById(loginButtonId).get(0);

        login.sendKeys(loginText);
        password.sendKeys(passwordText);
        loginButton.click();
    }
}
