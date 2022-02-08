package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementById {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // navigate to yahoo
        driver.get("https://yahoo.com");

        //identify and save the element
        WebElement inputBox = driver.findElement(By.id("ybar-sbq"));

        // enter text hello
       inputBox.sendKeys("Hello");

         // click on the search button
       WebElement searchBtn = driver.findElement(By.id("ybar-search"));
       searchBtn.click();

       String pageTitle = driver.getTitle();
        System.out.println("pageTitle = "+pageTitle);


       Thread.sleep(4000);

       driver.close();
    }
}
