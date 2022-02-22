package com.cydeo.tests.day7_Webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Sauce_Task {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void sauceTask() {
        //Find the username input and send the value
        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username' and @id='user-name']"));
        userName.sendKeys("standard_user");
        //Find the Password section and send the password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        //Click to log in button
        WebElement clickButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        clickButton.click();
        //select the item
        WebElement item = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
        //click to item
        item.click();
        //add item to cart
        WebElement cart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        cart.click();
        //click the cart
        WebElement clickTheShoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        clickTheShoppingCart.click();
        //click checkout
        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();
        //complete your information
        WebElement firstName = driver.findElement(By.xpath("//*[@*='first-name']"));
        firstName.sendKeys("edison");
        WebElement lastName = driver.findElement(By.xpath("//*[@*='last-name']"));
        lastName.sendKeys("kashari");
        WebElement zipCode = driver.findElement(By.xpath("//*[@*='postal-code']"));
        zipCode.sendKeys("07644");
        //click continue
        WebElement continue1 = driver.findElement(By.xpath("//*[@*='continue']"));
        continue1.click();
        //finish
        WebElement finish = driver.findElement(By.xpath("//button[@id='finish']"));
        finish.click();
        //veryfaing order is done

        WebElement orderIsDone = driver.findElement(By.xpath("//*[.='Checkout: Complete!']/span"));
        String actualText = orderIsDone.getText();
        String expectedText = "CHECKOUT: COMPLETE!";


          Assert.assertEquals(actualText, expectedText);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       BrowserUtils.sleep(3);
        driver.close();
    }
}
