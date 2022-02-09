package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zero_Bank_User_Password {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        //3. Enter username: username
        WebElement userName = driver.findElement(By.cssSelector("input[id='user_login']"));
        userName.sendKeys("edison");
        //4. Enter password: password
    WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
    password.sendKeys("kashari"+ Keys.ENTER);
        //5. Verify title changed to:
        //Expected: “Zero – Account Summary”
        System.out.println(driver.getTitle());
        if (driver.getTitle().equals("Zero – Account Summary")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        //driver.close();
    }
}
