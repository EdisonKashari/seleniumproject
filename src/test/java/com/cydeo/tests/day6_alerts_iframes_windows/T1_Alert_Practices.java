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

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void alert_test1() throws InterruptedException {
        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        Thread.sleep(3000);
        jsPrompt.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));

        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(expectedResult, result.getText());
    }

    @Test
    public void alert_test2(){




    }
    @AfterMethod
    public void tearDownMethod(){
      driver.close();
    }
}
