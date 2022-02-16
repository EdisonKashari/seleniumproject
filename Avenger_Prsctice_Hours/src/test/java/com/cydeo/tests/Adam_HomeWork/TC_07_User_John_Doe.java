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
        WebElement login = driver.findElement(By.xpath("//ul[@id='top-menu']//a[.='LOGIN']"));
        login.click();
        //4-enter username "User1"
        WebElement userName = driver.findElement(By.xpath("//div[@class='input-prepend']//input[@id='prependedInput']"));
        userName.sendKeys("User1");

        //5-enter password "UserUser123"
        WebElement password = driver.findElement(By.xpath("//div[@class='input-prepend input-prepend--last']/input"));
        password.sendKeys("UserUser123");

        //6-click LOG IN
        WebElement loginElement = driver.findElement(By.xpath("//div[@class='form-signin__footer control-group form-row']/button"));
        loginElement.click();

        //7-verify the user John Doe
       String userJohnDoe = driver.findElement(By.cssSelector(".dropdown-toggle")).getText();



        String expectedResult = "John Doe";

        if (userJohnDoe.equals(expectedResult)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

driver.close();


    }
}
