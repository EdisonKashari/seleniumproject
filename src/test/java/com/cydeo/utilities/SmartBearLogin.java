package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartBearLogin {


    public static void loginSmartBear(WebDriver driver){
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
    }
}
