package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T4_Iframe {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/iframe");

    }
    @Test
    public void iframeTest(){
        driver.switchTo().frame("mce_0_ifr");
        WebElement textYourContent = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(textYourContent.isDisplayed());

        driver.switchTo().parentFrame();
        WebElement textAniFrame = driver.findElement(By.xpath("//h3"));
        String expectedResult = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(textAniFrame.getText(),expectedResult);
    }
    //1. Create a new class called: T4_Iframes
    //2. Create new test and make set ups
    //3. Go to: https://practice.cydeo.com/iframe
    //4. Assert: “Your content goes here.” Text is displayed.
    //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
}
