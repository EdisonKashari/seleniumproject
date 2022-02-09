package com.cydeo.tests.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazon_cssSelector {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //TC #3: Amazon link number verification
        //1. Open Chrome browser
        //2. Go to https://www.amazon.com
        driver.get("https://www.amazon.com");
        //3. Enter search term (use cssSelector to locate search box)
        Thread.sleep(3000);

      WebElement searchTerm = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));

      searchTerm.sendKeys("search"+ Keys.ENTER);



      if (driver.getTitle().contains("search")){
          System.out.println("Title contain search");
      }else {
          System.out.println("Title not contain search");
      }
        //4. Verify title contains search term

    }
}
