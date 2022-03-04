package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NumberOfTheLinks {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");
    }
    @Test
    public void numberOfLinks(){
        List<WebElement> numberOfLinks = driver.findElements(By.xpath("//a"));
        System.out.println("numberOfLinks.size() = " + numberOfLinks.size());
        int actualSize = numberOfLinks.size();
        int expectedSize = 325;
        Assert.assertEquals(actualSize,expectedSize);


    }

   @Test
    public void textOfLinks(){
        List<WebElement> numberOfLinks = driver.findElements(By.xpath("//a[.=text()]"));
        for (WebElement each : numberOfLinks) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void linksWithoutTexts(){
        List<WebElement> numberOfLinks = driver.findElements(By.xpath("//a"));
        int count = 0;
        for (WebElement each : numberOfLinks) {

            try {
                if (each.getText().isEmpty()){
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        int expectedResult = 227;
        int actualResult = count;

        Assert.assertEquals(expectedResult,actualResult);


    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(3);
        driver.quit();
    }

}
//TC #1: Checking the number of links on the page
//1. Open Chrome browser
//2. Go to https://www.openxcell.com
//3. Count the number of the links on the page and verify
//Expected: 332
//
//TC #2: Printing out the texts of the links on the page
//1. Open Chrome browser
//2. Go to https://www.openxcell.com
//3. Print out all of the texts of the links on the page
//
//TC #3: Counting the number of links that does not have text
//1. Open Chrome browser
//2. Go to https://www.openxcell.com
//3. Count the number of links that does not have text and verify
//Expected: 109
//
//NOTE: EXPECTED NUMBER OF LINKS FOR THIS PRACTICE MAY BE DIFFERENT
//FROM COMPUTER TO COMPUTER, OR FOR DIFFERENT OS (MAC-WINDOWS). SO
//IF YOU ARE GETTING A DIFFERENT NUMBER, JUST USE THAT NUMBER FOR
//VERIFICATION.