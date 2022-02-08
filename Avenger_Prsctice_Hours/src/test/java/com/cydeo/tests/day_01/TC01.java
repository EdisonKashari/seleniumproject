package com.cydeo.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01 {
    public static void main(String[] args) {
        //Setup the "browser driver"
        // 1- Setup the "browser driver"

        WebDriverManager.chromedriver().setup();


        // 2- Create instance of the Selenium WebDriver, this is the line opening an empty browser

        WebDriver driver = new ChromeDriver();


        // 3- Maximize the browser size

        driver.manage().window().maximize();


        //Go to "https://www.selenium.dev/"

      driver.get("https://www.selenium.dev/");



        //Verify the URL

        String exceptedURl= "https://www.selenium.dev/";
        String actualURL = driver.getCurrentUrl();

        if (exceptedURl.equals(actualURL)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.close();
    }
}
