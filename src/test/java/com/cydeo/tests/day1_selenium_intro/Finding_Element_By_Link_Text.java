package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Finding_Element_By_Link_Text {
    public static void main(String[] args) throws InterruptedException {

       // set up the browser and create WebDriver instance
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
       // navigate to google.com
        driver.get("https://google.com");
       //identify and save the about link element on the top
        WebElement aboutLink = driver.findElement(By.linkText("About"));
       // click the link
        aboutLink.click();
        //wait 3 seconds
        Thread.sleep(3000);

        //identify and save the products link element on the top
        WebElement productLink = driver.findElement(By.linkText("Get product support"));
        productLink.click();

        //wait 3 seconds
        Thread.sleep(3000);

        //identify and save the you tube link element on the top
        WebElement youtubeLink = driver.findElement(By.linkText("YouTube"));
       youtubeLink.click();


        //wait 3 seconds
        Thread.sleep(3000);

        //close the browser
        driver.quit();




    }
}
