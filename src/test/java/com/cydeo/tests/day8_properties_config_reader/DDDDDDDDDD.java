package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DDDDDDDDDD {
    public WebDriver driver;

    @Test
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Users are on the homepage

        driver.get("https://login2.nextbasecrm.com/");

        //user logs in
        // Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr28@cydeo.com");

        // Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        // need to use the configuration.properties



        // Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //Users click the TASK tab

        //driver.findElement(By.id("feed-add-post-form-tab-tasks")).click();
        WebElement taskTab = driver.findElement(By.id("feed-add-post-form-tab-tasks"));
        taskTab.click();

        // Users write task title and task content/message


        WebElement thingsToDo = driver.findElement(By.xpath("//input[@data-bx-id= 'task-edit-title']"));
        thingsToDo.sendKeys("CRM Project");

        WebElement iframe = driver.findElement(By.xpath("//div[@id='bx-html-editor-iframe-cnt-lifefeed_task_form']/iframe"));

        driver.switchTo().frame(iframe);


        WebElement messageTab = driver.findElement(By.xpath("//body[@style='min-height: 84px;']"));
        messageTab.sendKeys("CRM project detailsss");

        // switch the iframe

        // driver.findElement(By.xpath("//input[@data-bx-id= 'task-edit-title']")).sendKeys("CRM Project ");



        // Users write task content/message (I could not do this)





        //driver.findElement(By.xpath("//input[@data-bx-body= 'contenteditable']")).sendKeys("CRM Project Details");


        //Users click the SEND button
        driver.switchTo().parentFrame();
        driver.findElement(By.id("blog-submit-button-save")).click();

        //Verify the task is displayed on the feed

        driver.findElement(By.xpath("//span[@class='menu-item-link-text']"));



    }

}

