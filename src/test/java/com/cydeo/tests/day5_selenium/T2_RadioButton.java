package com.cydeo.tests.day5_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_RadioButton {
    public static void main(String[] args) throws InterruptedException {
        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        //3. Click to “Hockey” radio button
        WebElement hockeyBtn = driver.findElement(By.xpath("//input[@id='hockey']"));

        hockeyBtn.click();
        Thread.sleep(3000);
        //4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("hockeyBtn.isSelected() = " + hockeyBtn.isSelected());
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        hockeyBtn.click();
        Thread.sleep(3000);
        System.out.println("hockeyBtn.isSelected() = " + hockeyBtn.isSelected());

        driver.close();
    }
}
