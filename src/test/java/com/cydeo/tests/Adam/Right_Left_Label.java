package com.cydeo.tests.Adam;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Right_Left_Label {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1- Open a chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void Right_LeftLabel() {
        //2- Go to https://the-internet.herokuapp.com/
        driver.get("https://the-internet.herokuapp.com/");
        WebElement frameButton = driver.findElement(By.xpath("//li/a[.='Frames']"));
        frameButton.click();
        //3- Click Nested Frames
        driver.findElement(By.xpath("//li/a[.='Nested Frames']")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");


        WebElement rightLabel = driver.findElement(By.xpath("//body"));

        String expectedResult = "RIGHT";
        String actualResult = rightLabel.getText();
        Assert.assertEquals(expectedResult, actualResult);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");
        WebElement lefttLabel = driver.findElement(By.xpath("//body"));
        expectedResult = "LEFT";
        actualResult = lefttLabel.getText();
        Assert.assertEquals(expectedResult, actualResult);


    }


}
//TC 4: As a User I should be able to see RİGHT label and LEFT label
//1- Open a Chrome browser
//2- Go to https://the-internet.herokuapp.com/
//3- Click Nested Frames
//4- Verify the RİGHT label
//5- Verify the LEFT label