package com.cydeo.tests.Adam_HomeWork;

import com.cydeo.utilitiesAdam.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_06_I_Should_Be_Able {
    public static void main(String[] args) throws InterruptedException {
        //1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        Thread.sleep(3000);
        //3-click Login label
        WebElement login = driver.findElement(By.xpath("//a[.='LOGIN']"));
        login.click();
        //4-enter username "User1"
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("User1");
        //5-enter password "UserUser123"
        WebElement password = driver.findElement(By.cssSelector("input[id='prependedInput2']"));
        password.sendKeys("UserUser123");
        //6-verify the password is hidden
    }
}
