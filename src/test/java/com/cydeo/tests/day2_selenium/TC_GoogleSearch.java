package com.cydeo.tests.day2_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_GoogleSearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        WebElement searchBtn = driver.findElement(By.name("q"));

        searchBtn.sendKeys("apple" + Keys.ENTER);

       // WebElement clickGoogle = driver.findElement(By.name("btnK"));

      //  clickGoogle.submit();


        String expestedInTitle = "apple";

        String actualTitle = driver.getTitle();


        if (actualTitle.startsWith(expestedInTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Not Pass");
        }

    }
}
/*
TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Click google search button
5- Verify title:
Expected: Title should start with “apple” word

 */