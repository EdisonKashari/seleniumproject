package com.cydeo.tests.day5_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_StateElement {
    public static void main(String[] args) throws InterruptedException {
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/add_remove_elements/");
        //3. Click to “Add Element” button
        WebElement addElement = driver.findElement(By.xpath("//div[@class='example']/button"));
        Thread.sleep(3000);
        addElement.click();
        //4. Verify “Delete” button is displayed after clicking.

        WebElement deleteBtn = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        //5. Click to “Delete” button...
        deleteBtn.click();
       //

        //6. Verify “Delete” button is NOT displayed after clicking.

        try {
            System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Delete button is Not displayed PASSED");
        }
        driver.close();
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        //

    }
}
