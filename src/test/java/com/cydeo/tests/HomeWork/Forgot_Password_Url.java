package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgot_Password_Url {
    public static void main(String[] args) throws InterruptedException {
        //TC #3: PracticeCybertek/ForgotPassword URL verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //3. Enter any email into input box
        WebElement email = driver.findElement(By.cssSelector("input[name='email']"));

        email.sendKeys("edisonkashari@hotmail.com");
        //4. Click on Retrieve password
        Thread.sleep(3000);
        WebElement retrievePassword = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));

        retrievePassword.click();
        //5. Verify URL contains:
        //Expected: “email_sent”
        if (driver.getCurrentUrl().contains("email_sent")){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        //6. Verify textbox displayed the content as expected.
        //Expected: “Your e-mail’s been sent!”Your e-mail's been sent!
        WebElement textBox = driver.findElement(By.xpath("//h4[@name='confirmation_message']"));

        System.out.println(textBox.getText());

        if (textBox.getText().equals("Your e-mail's been sent!")){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        driver.close();
        //Hint: You need to use getText method for this practice.
    }
}
