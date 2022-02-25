package com.cydeo.tests.Adam;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Check_Box {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void checkBox(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
       String expectedTitle = "Web Orders Login";
        Assert.assertEquals(driver.getTitle(),expectedTitle);

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test"+ Keys.ENTER);

        WebElement PaulButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
        PaulButton.click();

        Assert.assertTrue(PaulButton.isSelected());
        PaulButton.click();

        List<WebElement>  allCheckBox = driver.findElements(By.xpath("//tbody/tr/td/input[@type='checkbox']"));

        for (WebElement checkBox : allCheckBox) {
            checkBox.click();
           Assert.assertTrue(checkBox.isSelected());
        }


    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(3);
        driver.close();
    }

}
///* TC-1: SmartBearSoftware CheckBox Button Test
//1- Open a chrome browser
//2- Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3- Verify title equals: Expected: Web Orders Login
//4- Enter username: Tester
//5- Enter password: test
//6- Click “Sign In” button
//7- Locate and click checkbox button for Paul Brown
//8- Verify Paul Brown checkbox is selected
//9- Click checkbox button for All
//10- Verify All checkbox is selected.*/