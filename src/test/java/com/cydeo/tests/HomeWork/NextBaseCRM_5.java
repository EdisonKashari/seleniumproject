package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NextBaseCRM_5 {
    public static void main(String[] args) {
        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        //3- Enter incorrect username into login box:
        WebElement userName = driver.findElement(By.className("login-inp"));
        userName.sendKeys("edison");
        //4- Click to `Reset password` button
/*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement resetPassword = driver.findElement(By.tagName("button"));
        resetPassword.click();
*/
        WebElement css = driver.findElement(By.cssSelector("button[class='login-btn']"));
        css.click();
        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        //
    }
}
