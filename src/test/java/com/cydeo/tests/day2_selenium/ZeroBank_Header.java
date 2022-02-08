package com.cydeo.tests.day2_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank_Header {
    public static void main(String[] args) {

        //1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

      //  driver.getTitle();



        WebElement actualResult = driver.findElement(By.tagName("h3"));
        String  expectedresultResult = "Log in to ZeroBank";

        String actualHeader = actualResult.getText();


      if (actualHeader.equals(expectedresultResult)){
          System.out.println("Pass");
      }else {
          System.out.println("Failed");
      }

      driver.quit();


    }
}
/*
TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
 */