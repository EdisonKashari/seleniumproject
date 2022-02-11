package com.cydeo.tests.Adam_HomeWork;

import com.cydeo.utilitiesAdam.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_04_Login {
    public static void main(String[] args) throws InterruptedException {
        ////1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        // //3-verify Login is displayed
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.xpath("//a[@href='http://app.vytrack.com']"));
        Thread.sleep(3000);
        login.click();
    }
}
