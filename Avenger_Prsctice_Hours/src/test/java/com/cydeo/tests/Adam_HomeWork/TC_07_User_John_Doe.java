package com.cydeo.tests.Adam_HomeWork;

import com.cydeo.utilitiesAdam.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_07_User_John_Doe {
    public static void main(String[] args) {
        //1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        //3-click Login label
        WebElement login = driver.findElement(By.xpath("//a[.='LOGIN']"));
        login.click();
        //4-enter username "User1"
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("User1");
        //5-enter password "UserUser123"
        WebElement password = driver.findElement(By.cssSelector("input[id='prependedInput2']"));
        password.sendKeys("UserUser123");
        //6-click LOG IN
        WebElement login1 = driver.findElement(By.cssSelector("button[type='submit']"));
        login1.click();
        //7-verify the user John Doe
       WebElement user = driver.findElement(By.cssSelector("a[class='dropdown-toggle']"));
       if (user.getText().contains("John Doe")){
           System.out.println("The user is John Doe");
       }else {
           System.out.println("The user is not John Doe");
       }
       driver.close();
    }
}
