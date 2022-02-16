package com.cydeo.tests.Adam_HomeWork;

import com.cydeo.utilitiesAdam.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_03_Contact {
    public static void main(String[] args) throws InterruptedException {
        ////1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        // //3-verify Contact is displayed and label is "Contact"
        WebElement contact = driver.findElement(By.xpath("//a[.='Contact']"));
        // WebElement contactWebElement = driver.findElement(By.xpath("//ul[@id='top-menu']//*[contains(@href,'contact')]"));
        Thread.sleep(2000);

        if (contact.isDisplayed()) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        Thread.sleep(2000);
        //  driver.close();

    }
}
