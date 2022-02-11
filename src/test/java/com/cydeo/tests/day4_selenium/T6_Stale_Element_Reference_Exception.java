package com.cydeo.tests.day4_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T6_Stale_Element_Reference_Exception {
    public static void main(String[] args) {
        //TC #6: StaleElementReferenceException Task
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeo = driver.findElement(By.cssSelector("a[target='_blank']"));

        System.out.println("cydeo.isDisplayed() = " + cydeo.isDisplayed());
        //4- Refresh the page.
        driver.navigate().refresh();
        //5- Verify it is displayed, again.
        cydeo = driver.findElement(By.cssSelector("a[target='_blank']"));
        System.out.println("cydeo.isDisplayed() = " + cydeo.isDisplayed());
    }
}
