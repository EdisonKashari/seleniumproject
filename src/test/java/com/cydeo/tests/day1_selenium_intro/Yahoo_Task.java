package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Yahoo_Task {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();


        driver.get("https://www.yahoo.com");

       String actualTitle= driver.getTitle();


         String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

         if (actualTitle.equals(expectedTitle)){

             System.out.println("Title is as excepted. Verification PASSED");
         }else {

             System.out.println("Title is NOT as expected.Verification NOT PASSED");
         }
Thread.sleep(3000);
         driver.close();

    }
}
