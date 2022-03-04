package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Farangez_Task {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();


    }

    @Test
    public void verify_Message() {


        WebElement chatCallModule = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        chatCallModule.click();

        WebElement messageTab = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im']/.."));

        String actualResult = messageTab.getAttribute("title");

        String expectedResult = "Message";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void verifyNotifications() {


        WebElement chatCallModule = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        chatCallModule.click();
        WebElement notificationTab = driver.findElement(By.xpath("//div[@data-id='notify']"));
        String actualResult = notificationTab.getAttribute("title");
        String expectedResult = "Notifications";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void settingsVerify() {


        WebElement chatCallModule = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        chatCallModule.click();

        WebElement settingTab = driver.findElement(By.xpath("//div[@data-id='config']"));
        String actualResult = settingTab.getAttribute("title");

        String expectedResult = "Settings";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void activeStream() {


        WebElement chatCallModule = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        chatCallModule.click();

        WebElement activeStreamTab = driver.findElement(By.xpath("//div[@data-id='im-lf']"));
        System.out.println("activeStreamTab.getAttribute(\"title\") = " + activeStreamTab.getAttribute("title"));
        String actualResult = activeStreamTab.getAttribute("title");

        String expectedResult = "Activity Stream ";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }

}
//Acceptance Criteria:
//1. There should be four sub-modules once the user click the Chat and Calls module:
//1. Message
//2. Notifications
//3. Settings
//4. Active Stream
//scenarios :
//1. Verify users (HR, marketing, Helpdesk) access to the Chat and Calls submodules.