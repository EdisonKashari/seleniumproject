package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CydeoPractice {

    public static void main(String[] args) throws InterruptedException {
        //1-Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2-Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com ");

        String URLResult = driver.getCurrentUrl();

        String URLExcepted= "cydeo";

        if (URLResult.contains(URLExcepted)){
            System.out.println("URL is as excepted. Verification PASSED");

        }else {
                System.out.println("URL is not as exceptet.Verification Not PASSED");
        }




        String expectedResult = "Practice";

        String currentResult = driver.getTitle();


        if (expectedResult.equals(currentResult)){
            System.out.println("Title is as excepted. Verification PASSED");

        }else {
            System.out.println("Title is not as exceptet.Verification Not PASSED");
        }
        //wait 4 second
        Thread.sleep(4000);
        //close the brow
       // driver.close();


    }
}
