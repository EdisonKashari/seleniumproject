package com.cydeo.tests.day7_Webtables_utilities_javafaker;

import com.cydeo.tests.TestBase.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_CRM_LOGIN extends TestBase {




  @Test
    public void crm_logintest() {
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3. Enter valid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys("helpdesk1@cybertekschool.com");
        //4. Enter valid password
        WebElement inputpassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputpassword.sendKeys("UserUser");
        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
        //6. Verify title is as expected:
        BrowserUtils.verifyTitle(driver, "(1) Portal");
    }

    @Test
    public void  crm_logintest2() {
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk
        CRM_Utilities.crm_login(driver);

        System.out.println("driver.getTitle() = " + driver.getTitle());
        //6. Verify title is as expected:
        BrowserUtils.verifyTitle(driver, "(1) Portal");

    }
    @Test
    public void  crm_logintest3() {
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk
        CRM_Utilities.crm_login(driver,"helpdesk1@cybertekschool.com","UserUser");


        //6. Verify title is as expected:
        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(driver, "(1) Portal");

    }
}
