package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T3_Alert {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/javascript_alerts");




    }
    @Test
    public void alertTest() throws InterruptedException {
        WebElement JSButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        JSButton.click();
Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        String expectedResult = "You entered: hello";

        WebElement text = driver.findElement(By.xpath("//p[.='You entered: hello']"));
        String actualResult = text.getText();

        Assert.assertEquals(actualResult,expectedResult);

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts
    //3. Click to “Click for JS Prompt” button
    //4. Send “hello” text to alert
    //5. Click to OK button from the alert
    //6. Verify “You entered:  hello” text is displayed.
}
