package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Web_Table {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void verifyCities() {

        List<WebElement> stateName = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr//td[contains(text(),'art')]/following-sibling::td[6]"));

        ArrayList<String> actualState = new ArrayList<>();

        for (WebElement each : stateName) {

            actualState.add(each.getText());

        }

        ArrayList<String> expectedState = new ArrayList<>(Arrays.asList("Canada", "US", "US"));


        Assert.assertEquals(actualState, expectedState);


    }


}
//TC 1:
//1- go to https://practice.cydeo.com/web-tables
//2- verify cities contains ‘art’ in their names
//Expected Result:[“Canada”,”US”,”US”]