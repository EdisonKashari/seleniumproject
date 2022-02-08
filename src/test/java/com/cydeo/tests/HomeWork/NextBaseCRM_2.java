package com.cydeo.tests.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextBaseCRM_2 {
    public static void main(String[] args) {
        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement login = driver.findElement(By.className("login-item-checkbox-label"));

        if (login.getText().equals("Remember me on this computer")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));

        if (forgotPassword.getText().equals("FORGOT YOUR PASSWORD?")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        WebElement attribute = driver.findElement(By.className("login-link-forgot-pass"));

        if (attribute.getAttribute("href").contains("forgot_password=yes")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.close();

        //
        //
        //
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
    }
}
