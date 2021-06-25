package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase{

    @Test
    public void changeLanguageTest(){
//        Select lgDropDown = new Select(driver.findElement(By.name("language")));
        Select lgDropDown = new Select(driver.findElement(By.cssSelector("[name=\"language\"]")));
//        lgDropDown.selectByIndex(2);
        lgDropDown.selectByValue("ru");
//        lgDropDown.selectByVisibleText("français");

        WebElement submitLgButton = driver.findElement(By.cssSelector("[data-loading-text=\"Submitting...\"]"));
        submitLgButton.click();

        WebElement basketButton = driver.findElement(By.className("btn-group"));
        String text = basketButton.getText();
//        Assert.assertEquals(text, "Пос0мотреть корзину");
        Assert.assertEquals(text, "Посмотреть корзину", "Text not valid"); // we'll see "Text not valid" if expected is not the same as text
//        Assert.assertEquals(text, "Посмотреть корзину1", "Text not valid"); // negative
    }
}
