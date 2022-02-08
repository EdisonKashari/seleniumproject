package com.cydeo.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC04 {
    private static WebDriver driver;

    public static void main(String[] args) {

        goToGoogle("https://www.google.com");

        verifyWord("Google");
    }

    private static void verifyWord(String ecxeptetResult) {
        String actualResult = driver.getTitle();
        if (actualResult.contains(ecxeptetResult)){
            System.out.println("PASS");
        }else {
            System.out.println("FAILED");
        }

    }

    private static void goToGoogle(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
//Setup the "browser driver"

    //Go to "https://www.google.com"

    //Verify the title contains "Google"

    //Navigate to "https://www.etsy.com"

    //Verify not in google page

    //Verify the title  contains "Etsy"
}
