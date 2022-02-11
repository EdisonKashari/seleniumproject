package com.cydeo.tests.Adam_HomeWork;

import com.cydeo.utilitiesAdam.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_08_Seam_Lessly {
    public static void main(String[] args) {
        //1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2-goto https://app.seamlessly.net/index.php/login
        driver.get("https://app.seamlessly.net/index.php/login");
        //3-enter password "UserUser123"
        WebElement password = driver.findElement(By.cssSelector("input[class='password-with-toggle']"));
        password.sendKeys("UserUser123");
        //4-verify password as "*****"
        //5-click eye icon
        WebElement eye = driver.findElement(By.xpath("//a[@class='toggle-password']"));
        eye.click();
        //6-verify that password is shown
    }
}
