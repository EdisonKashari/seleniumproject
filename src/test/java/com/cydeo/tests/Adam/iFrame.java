package com.cydeo.tests.Adam;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFrame {
    WebDriver driver;
    //TC 1: As a User I should be able to see ‘Your content goes here.’ And ‘An iFrame
    //containing the TinyMCE WYSIWYG Editor’


    @BeforeMethod
    public void setupMethod() {
        //1- Open a chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void iFrame() {
        //2- Go to https://the-internet.herokuapp.com/
        driver.get("https://the-internet.herokuapp.com/");
        //3- Click iFrame
        WebElement frameButton = driver.findElement(By.xpath("//li/a[.='Frames']"));
        frameButton.click();
        WebElement iFrame = driver.findElement(By.xpath("//li/a[@href='/iframe']"));
        iFrame.click();


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));

        //4- Verify the ‘Your content goes here.’ label
        WebElement contectText = driver.findElement(By.xpath("//p"));

        String expectedText = "Your content goes here.";
        String actualText = contectText.getText();
        Assert.assertEquals(expectedText, actualText);
        driver.switchTo().defaultContent();

        //5- Verify the header ‘An iFrame containing the TinyMCE WYSIWYG Editor

        WebElement verifyHeader = driver.findElement(By.xpath("//h3"));

        expectedText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        actualText = verifyHeader.getText();
        Assert.assertEquals(expectedText, actualText);
    }

}
