package com.cydeo.tests.day5_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleSelectDropDown {
    WebDriver driver;

    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Select all the options from multiple select dropdown.
    //4. Print out all selected values.
    //5. Deselect all values.
    @BeforeMethod
    public void setupWebDriver() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void multipleDropDown() {

        Select allLanguages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        allLanguages.selectByVisibleText("Java");
        allLanguages.selectByValue("js");
        allLanguages.selectByVisibleText("C#");
        allLanguages.selectByVisibleText("Python");
        allLanguages.selectByVisibleText("Ruby");
        allLanguages.selectByVisibleText("C");

        List<WebElement> list = allLanguages.getAllSelectedOptions();

        for (WebElement each : list) {

            System.out.println("each.getText() = " + each.getText());
        }

        allLanguages.deselectAll();
    }
    @AfterMethod
    public void tearDropDown(){
        driver.close();
    }

}
