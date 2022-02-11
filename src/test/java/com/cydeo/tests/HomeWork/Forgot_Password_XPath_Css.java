package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Forgot_Password_XPath_Css {
    public static void main(String[] args) throws InterruptedException {
        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //2. Go to http://practice.cydeoschool.com/forgot_password
        driver.get("http://practice.cydeo.com/forgot_password");
        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link

        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //  homeLink.click();

        //b. “Forgot password” header
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //c. “E-mail” text

        WebElement email = driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        // inputBox.sendKeys("edison");
        //e. “Retrieve password” button

        WebElement retrievePassword = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        //retrievePassword.click();

        //f. “Powered by Cydeo” text
        WebElement poweredByCydeo = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        System.out.println(poweredByCydeo.getText());
        if (poweredByCydeo.getText().equals("Powered by CYDEO")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }



        //4. Verify all WebElements are displayed.

        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("forgotPassword.isDisplayed() = " + forgotPassword.isDisplayed());
        System.out.println("email.isDisplayed() = " + email.isDisplayed());
        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());
        System.out.println("retrievePassword.isDisplayed() = " + retrievePassword.isDisplayed());
        System.out.println("poweredByCydeo.isDisplayed() = " + poweredByCydeo.isDisplayed());
         driver.close();
    }
}
