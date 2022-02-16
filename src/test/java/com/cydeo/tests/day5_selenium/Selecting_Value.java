package com.cydeo.tests.day5_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Selecting_Value {
    WebDriver driver;
    //TC #7: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”
    @BeforeMethod
    public void setupBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");


    }
    @Test
    public void valueDropDown(){
        WebElement dropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropdown.click();

        WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));
        facebook.click();

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

          Assert.assertEquals(actualTitle,"Facebook - Log In or Sign Up");
    }
    @AfterMethod
    public void tearDropDown(){
        driver.close();
    }
}
