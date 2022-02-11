package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgot_Password_XPath_Css {
    public static void main(String[] args) throws InterruptedException {
        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        Thread.sleep(3000);
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
      //  homeLink.click();

        //b. “Forgot password” header
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //c. “E-mail” text
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.xpath("//label[@for='email']"));
        email.click();
        //d. E-mail input box

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
       // inputBox.sendKeys("edison");
        //e. “Retrieve password” button

        WebElement retrievePassword = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        //retrievePassword.click();

        //f. “Powered by Cybertek School” text
        WebElement poweredByCybertek = driver.findElement(By.cssSelector("div[style='text-align: center;']"));


       if (poweredByCybertek.getText().equals("Powered by ")){
           System.out.println("PASSED");
       }else {
           System.out.println("FAILED");
       }
        Thread.sleep(3000);
     //  driver.close();

        //4. Verify all WebElements are displayed.
    }
}
