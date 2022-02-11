package com.cydeo.tests.Adam_HomeWork;

import com.cydeo.utilitiesAdam.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_05_Login_URL {
    public static void main(String[] args) throws InterruptedException {
        ////1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        // //3-click Login label
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.xpath("//a[.='LOGIN']"));
        login.click();
        // //4-verify the url contains login

        if (driver.getCurrentUrl().contains("login")){
            System.out.println("Current url is Passed");
        }else {
            System.out.println("Current url is not Passed");
        }

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.close();
    }
}
