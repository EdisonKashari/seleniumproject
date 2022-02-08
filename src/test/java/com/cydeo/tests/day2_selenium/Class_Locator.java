package com.cydeo.tests.day2_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class_Locator {
    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        Thread.sleep(3000);

        //3- Click to “Home” link
        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();
        String actualResult = driver.getTitle();
        String expectedResult = "Practice";

        //4- Verify title is as expected:
        //Expected: Practice
        if (actualResult.equals(expectedResult)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
        Thread.sleep(3000);
        driver.close();

    }

}
/*
TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice

PS: Locate “Home” link using “className” locator

 */