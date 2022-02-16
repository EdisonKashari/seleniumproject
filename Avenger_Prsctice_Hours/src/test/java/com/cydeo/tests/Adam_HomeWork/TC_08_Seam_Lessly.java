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
        String type = password.getAttribute("type");
        if (type.equals("password")){
            System.out.println("Password is hidden and Passed");
        }else {
            System.out.println("Password is not hidden and Failed");
        }

        //5-click eye icon
        driver.findElement(By.xpath("//a[@class='toggle-password']")).click();


        type = password.getAttribute("type");

        if (type.equals("text")){
            System.out.println("Password is shown and Passed");
        }else {
            System.out.println("Password is not shown and Failed");
        }

        //6-verify that password is shown
    }
}
