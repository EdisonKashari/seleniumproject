package com.cydeo.tests.day5_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Selecting_State {
    WebDriver driver;


    //TC #5: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    @BeforeMethod
    public void setupBrowserTest() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropDownMethod() {
        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
         //3. Select Illinois
        dropDown.selectByIndex(14);
        //4. Select Virginia
        dropDown.selectByVisibleText("Virginia");
        //5. Select California
        dropDown.selectByValue("CA");

        String expecteresult = "California";
        WebElement actualResult = dropDown.getFirstSelectedOption();
        String actualText = actualResult.getText();
        System.out.println("actualText = " + actualText);
        //6. Verify final selected option is California.
        Assert.assertEquals(actualText, expecteresult);
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

    //Use all Select options. (visible text, value, index)
}
