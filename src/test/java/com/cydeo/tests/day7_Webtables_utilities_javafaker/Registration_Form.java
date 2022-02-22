package com.cydeo.tests.day7_Webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Registration_Form {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/registration_form");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
         driver.close();
    }

    @Test
    public void registrationForm() {
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Edison");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Kashari");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("EdisonKashari");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("edisonkashari@hotmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("862-703-9302");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.xpath("//input[@name='birthday' and @placeholder='MM/DD/YYYY']")).sendKeys("05/09/1990");
        Select department = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        department.selectByVisibleText("Department of Engineering");
        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(4);
        driver.findElement(By.xpath("//input[@value='java']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

    }

}
