package com.cydeo.tests.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com/");

        WebElement searchBtn = driver.findElement(By.id("global-enhancements-search-query"));

        searchBtn.sendKeys("Wooden Spoon"+ Keys.ENTER);

        String current =  driver.getTitle();

        String expectedTitle = "Wooden spoon | Etsy";

        if (current.equals(expectedTitle)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
    driver.close();

    }
}


/*
TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com/
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
 */