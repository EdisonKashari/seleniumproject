package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Zero_Bank_Title_Verification {
    public static void main(String[] args) {
        //TC #1: Zero Bank title verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        //3. Verify title

        //Expected: “Zero - Log in”
        if (driver.getTitle().equals("Zero - Log in")){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }
}
