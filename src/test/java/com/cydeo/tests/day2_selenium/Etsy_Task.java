package com.cydeo.tests.day2_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy_Task {
    public static void main(String[] args) {

       // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //3. Search for “wooden spoon”
        WebElement searchWooden = driver.findElement(By.id("global-enhancements-search-query"));

        searchWooden.sendKeys("wooden spoon");

        searchWooden.submit();

     String actualTitle = driver.getTitle();

        String expectedTitle = "Wooden spoon | Etsy";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

        driver.close();

    }
}
/*

TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
 */