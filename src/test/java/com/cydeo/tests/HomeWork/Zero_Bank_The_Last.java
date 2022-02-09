package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zero_Bank_The_Last {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //TC #4: Zero Bank login title verification
        //1. Open Chrome browser
        //2. Go to http://zero.webappsecurity.com/login.html  http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        //3. Enter username: username
        WebElement userName = driver.findElement(By.cssSelector("input[id='user_login']"));
        userName.sendKeys("edison");
        //4. Enter password: password
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("kashari");

        //5. Click to “Account Activity” link
        //6. Verify title changed to:
        //Expected: “Zero – Account Activity”
        //7. Click to “Transfer Funds” link
        //8. Verify title changed to:
        //Expected: “Zero – Transfer Funds”
        //9. Click to “Pay Bills” link
        //10. Verify title changed to:
        //Expected: “Zero - Pay Bills”
        //11. Click to “My Money Map” link
        //12. Verify title changed to:
        //Expected: “Zero – My Money Map”
        //13. Click to “Online Statements” link
        //14. Verify title changed to:
        //Expected: “Zero – Online Statements”
    }
}
