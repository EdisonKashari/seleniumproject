package com.cydeo.tests.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextBaseCrm_1 {
    public static void main(String[] args) {
        //TC #1: NextBaseCRM, locators and getText() practice
//1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


//2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

//3- Enter incorrect username: “incorrect”
        WebElement userName = driver.findElement(By.className("login-inp"));

        userName.sendKeys("edisonkashari");
//4- Enter incorrect password: “incorrect”
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));

        password.sendKeys("147258");
//5- Click to login button.

        WebElement loginBtn = driver.findElement(By.className("login-btn"));

//6- Verify error message text is as expected:
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginBtn.click();
        WebElement actualTitle = driver.findElement(By.className("errortext"));

        //Expected: Incorrect login or password

        if (actualTitle.getText().equals("Incorrect login or password")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }
}
