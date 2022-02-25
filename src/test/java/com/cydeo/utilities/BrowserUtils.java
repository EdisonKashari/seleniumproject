package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /*
        This method will accept int (int seconds) and execute Thread.sleep
        for given duration
         */
    public static void sleep(int second) {

        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
        }

    }

    /*
    This method accepts 3 arguments
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given string.
          -If conditions matches,will break loop
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle) {

        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                System.out.println("driver.getTitle() = " + driver.getTitle());
                break;

            }
        }


        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}