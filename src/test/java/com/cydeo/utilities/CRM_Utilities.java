package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
/*
This method with login with helpdesk1@cybertekschool.com
user when it is called

 */
public static void crm_login(WebDriver driver){
    //3. Enter valid username
    WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
    userName.sendKeys("helpdesk1@cybertekschool.com");
    //4. Enter valid password
    WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
    password.sendKeys("UserUser");
    //5. Click to Log In button
    WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
    loginButton.click();

}
    public static void crm_login(WebDriver driver,String username,String password){
        //3. Enter valid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys(username);
        //4. Enter valid password
        WebElement inputpassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputpassword.sendKeys(password);
        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }
}
