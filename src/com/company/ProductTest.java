package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductTest extends TestBase {

    @Test
    public void addProductToBasketTest(){
        selectBooksCategory();
        Assert.assertTrue(isItBooksPage());

        List<WebElement> productList = driver.findElements(By.className("product_pod"));
        String firstBookName = productList.get(0).findElement(By.tagName("h3")).getText();
        String firstBookPrice = productList.get(0).findElement(By.cssSelector(".product_price .price_color")).getText();

        addToBasketFirstBook(productList);
        Assert.assertTrue(alertsIsPresent());
        
        List<WebElement> alertsData = driver.findElements(By.cssSelector(".alert strong"));
        Assert.assertTrue(isItBookName(firstBookName, alertsData));
        Assert.assertTrue(isItBookPrice(firstBookPrice, alertsData));

    }

    private boolean isItBookPrice(String firstBookPrice, List<WebElement> alertsData) {
        return alertsData.get(2).getText().equals(firstBookPrice);
    }

    private boolean isItBookName(String firstBookName, List<WebElement> alertsData) {
        return alertsData.get(0).getText().equals(firstBookName);
    }

    private boolean alertsIsPresent() {
        return driver.findElements(By.className("alert")).size() == 3;
    }

    private void addToBasketFirstBook(List<WebElement> productList) {
        productList.get(0).findElement(By.cssSelector("[type=\"submit\"]")).click();
    }

    private boolean isItBooksPage() {
        return driver.findElement(By.className("page-header")).getText().contains("Books");
    }

    private void selectBooksCategory() {
        driver.findElement(By.className("dropdown-submenu")).click();
    }
}
