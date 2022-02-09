package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zero_Bank_Link {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        //3. Verify link text from top left:
        //Expected: “Zero Bank”
        WebElement zeroBank = driver.findElement(By.xpath("//a[@class='brand']"));
        if (zeroBank.getText().equals("Zero Bank")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        if (zeroBank.getAttribute("href").contains("index.html")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        //4. Verify link href attribute value contains:
        //Expected: “index.html”
        driver.close();
    }
}
