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

public class T2_Alert {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/javascript_alerts");


    }

    @Test
    public void alert() throws InterruptedException {
        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement okButton = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));

        String actualTitle = okButton.getText();
        String expectedTitle = "You clicked: Ok";


        Assert.assertEquals(actualTitle, expectedTitle);


    }
    @AfterMethod
    public void closeProgram(){
        driver.close();
    }

}
//            2. Go to website: http://practice.cydeo.com/javascript_alerts
//        ////3. Click to “Click for JS Confirm” button
//        ////4. Click to OK button from the alert
//        ////5. Verify “You clicked: Ok” text is displayed.