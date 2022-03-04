package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Verify {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void verify_test() {
        //Go to: https://practice.cydeo.com/web-tables

        //2. Verify Bob’s name is listed as expected.
        WebElement nameBobMartin = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr/td[.='Bob Martin']"));
        //Expected: “Bob Martin”
        //3. Verify Bob Martin’s order date is as expected
        String expectedText = "Bob Martin";
        String actualText = nameBobMartin.getText();

        Assert.assertEquals(expectedText, actualText);

        WebElement bobMartinDateCell =
                driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr/td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedBobDate = "12/31/2021";
        String actualBobDate = bobMartinDateCell.getText();

        Assert.assertEquals(expectedBobDate, actualBobDate);
    }

    @Test
    public void test2() {
        String costumerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");

        System.out.println("costumerOrderDate1 = " + costumerOrderDate1);



    }

    //Using WebTableUtils.orderVerify(); method
    @Test
    public void test3() {
        WebTableUtils.orderVerify(driver, "Bob Martin", "12/31/2021");
    }




    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }


}



