package com.cydeo.tests.day5_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StateElement_Solution_2 {
    WebDriver driver;


    //TC #1: StaleElementReferenceException handling
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/add_remove_elements/
    //3. Click to “Add Element” button
    //4. Verify “Delete” button is displayed after clicking.
    //5. Click to “Delete” button...
    //6. Verify “Delete” button is NOT displayed after clicking.
    @BeforeClass
    public void setupClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/add_remove_elements/");
    }


    @Test
    public void addElement() {
        WebElement addElement = driver.findElement(By.xpath("//div[@class='example']/button"));
        addElement.click();

    }

    @Test
    public void deleteButton() {
        WebElement deleteBtn = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());

        deleteBtn.click();

        try {
            System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Delete button is Not displayed PASSED");
        }

    }



    }


