package com.cydeo.tests.Adam;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MIDDLE_Label {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1- Open a chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void middleLabel() {
        //2- Go to https://the-internet.herokuapp.com/
        driver.get("https://the-internet.herokuapp.com/");
        WebElement frameButton = driver.findElement(By.xpath("//li/a[.='Frames']"));
        frameButton.click();
        //3- Click Nested Frames
        driver.findElement(By.xpath("//li/a[.='Nested Frames']")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        //4- Verify the MIDDLE label
        WebElement middleLabel = driver.findElement(By.xpath("//body/div"));
        System.out.println("middleLabel.getText() = " + middleLabel.getText());
        String expectedResult = "MIDDLE";
        String actualResult = middleLabel.getText();
        Assert.assertEquals(expectedResult, actualResult);


    }

}