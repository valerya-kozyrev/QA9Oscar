package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OscarShopTest {

    WebDriver driver;

    String email = "Tost" + System.currentTimeMillis() + "@gmail.com"; //random numbers for password
    String password = "Tost#1212";

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
        Thread.sleep(3000);
    }

    @Test//(priority = 1)
    public void registrationTest() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        loginLink.click();
        Thread.sleep(3000);

        WebElement emailField = driver.findElement(By.id("id_registration-email"));
        emailField.clear();
        emailField.sendKeys(email);
//        Thread.sleep(3000);

        WebElement passwordField = driver.findElement(By.id("id_registration-password1"));
        passwordField.sendKeys(password);
//        Thread.sleep(3000);

        WebElement confirmPasswordField = driver.findElement(By.id("id_registration-password2"));
        confirmPasswordField.sendKeys(password);
//        Thread.sleep(3000);

        WebElement registerButtton = driver.findElement(By.name("registration_submit"));
        registerButtton.click();
        Thread.sleep(3000);
    }

    @Test(priority = 2, dependsOnMethods = "registrationTest")
    public void loginTest() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        loginLink.click();
        Thread.sleep(3000);

//        WebElement loginEmailField = driver.findElement(By.id("id_login-username"));
//        WebElement loginEmailField = driver.findElement(By.cssSelector("#id_login-username"));
        WebElement loginEmailField = driver.findElement(By.xpath("//input[@id='id_login-username']"));
        loginEmailField.sendKeys(email);

        WebElement loginPasswordField = driver.findElement(By.id("id_login-password"));
        loginPasswordField.sendKeys(password);

//        WebElement loginButton = driver.findElement(By.name("login_submit"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
        loginButton.click();
        Thread.sleep(3000);
    }

}
