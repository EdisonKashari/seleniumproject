package com.cydeo.tests.day2_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Back_And_Forth_Navigation {

    public static void main(String[] args) throws InterruptedException {
        //1- Open a chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://google.com
        driver.get("https://google.com");

        Thread.sleep(3000);
        //3- Click to Gmail from top right.
        WebElement gmailClick = driver.findElement(By.linkText("Gmail"));
        gmailClick.click();
        String actualResult = driver.getTitle();
        String expectedResult = "Gmail";
       //4- Verify title contains:
        //  Expected: Gmail
        if (actualResult.contains(expectedResult)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
        //5- Go back to Google by using the .back();
        Thread.sleep(3000);
        driver.navigate().back();

        String actualGoogleResult= driver.getTitle();

        String expectedGoogleResult = "Google";
        //6- Verify title equals:
        //  Expected: Google
        if (actualGoogleResult.equals(expectedGoogleResult)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(3000);
        driver.quit();


    }
}
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
  Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
  Expected: Google
 */