package com.cydeo.tests.day2_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_Linktext_Practice {
    public static void main(String[] args) throws InterruptedException {

        //Starting stop watch to count time of test execution
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

       //2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com ");

       //3- Click to A/B Testing from top of the list.
      WebElement inputBox = driver.findElement(By.linkText("A/B Testing"));
     // Thread.sleep(3000);
      inputBox.click();
       //4- Verify title is:
        //  Expected: No A/B Test
      String expectedTitle = "No A/B Test";

      String actualTitle = driver.getTitle();

      if (actualTitle.equals(expectedTitle)){
          System.out.println("Pass");
      }else {
          System.out.println("Not Pass");
      }

       // Thread.sleep(3000);
      //5- Go back to home page by using the .back();
      driver.navigate().back();

      //6- Verify title equals:
        //  Expected: Practice
      String expectedTitle2 = "Practice";
      actualTitle= driver.getTitle();

      if (actualTitle.equals(expectedTitle2)){
          System.out.println("Title PASSED");
      }else {
          System.out.println("Title Not PASSED");
      }
    driver.close();

        stopWatch.stop();
        double totalTime = stopWatch.getTime();
        System.out.println("Total execution time: "+totalTime/1000.0+" seconds");


    }
}
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
  Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
  Expected: Practice
 */