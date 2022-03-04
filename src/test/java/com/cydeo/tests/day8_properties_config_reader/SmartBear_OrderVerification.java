package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.SmartBearLogin;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBear_OrderVerification {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearLogin.loginSmartBear(driver);
    }

    @Test
    public void orderVerification() {
        WebElement viewOrder = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewOrder.click();

        WebElement susanOrder = driver.findElement(By.xpath("//table/tbody//tr//td[.='Susan McLaren']/following-sibling::td[3]"));
        String actualResult = susanOrder.getText();
        String expectedResult = "01/05/2010";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(3);
        driver.close();
    }
}
//TC#3: Smartbear software order verification
//1. Open browser and login to Smartbear software
//2. Click on View all orders
//3. Verify Susan McLaren has order on date “01/05/2010”