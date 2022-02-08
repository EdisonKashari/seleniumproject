package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Finding_Element_ByName {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

      WebElement input = driver.findElement(By.name("q"));

      input.sendKeys("selenium");

      WebElement searchBtn = driver.findElement(By.name("btnK"));

      searchBtn.submit();

      Thread.sleep(4000);

      driver.navigate().back();
          // find the element by name
        WebElement tesla = driver.findElement(By.name("q"));

      tesla.sendKeys("tesla");

        //click in the search button
        WebElement searchBtnTesla= driver.findElement(By.name("btnK"));

        searchBtnTesla.submit();

      //close the browser

       // driver.quit();


    }
}
