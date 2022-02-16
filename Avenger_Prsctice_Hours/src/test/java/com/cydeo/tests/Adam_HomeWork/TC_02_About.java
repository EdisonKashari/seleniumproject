package com.cydeo.tests.Adam_HomeWork;

import com.cydeo.utilitiesAdam.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_02_About {
    public static void main(String[] args) throws InterruptedException {
        ////1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        // //3-verify About us is displayed
        Thread.sleep(3000);
        WebElement about = driver.findElement(By.cssSelector("a[href='https://vytrack.com/about-us/']"));
        System.out.println("about.isDisplayed() = " + about.isDisplayed());
        if (about.isDisplayed()){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
