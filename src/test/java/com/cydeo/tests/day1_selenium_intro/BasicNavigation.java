package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        //1-setup the browser driver
        WebDriverManager.chromedriver().setup();

        //2-create instance of the selenium Webdriver

        //this opening an empty browser
        WebDriver driver = new ChromeDriver();

        // This line will maximize the browser size
        driver.manage().window().maximize();



        //3-go to "https://www.tesla.com
        driver.get("https://www.tesla.com");


        String currentTitle = driver.getTitle();

        System.out.println("currentTitle = " + currentTitle);

        // Get the current URL using selenium
        String currenturl =   driver.getCurrentUrl();


        System.out.println("currenturl = " + currenturl);



        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();


        //Stop code execution for 3 seconds
        Thread.sleep(3000);


        // use selenium to navigate back
        driver.navigate().forward();


        //Stop code execution for 3 seconds
        Thread.sleep(3000);


        // use selenium to navigate refresh
        driver.navigate().refresh();



        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //use navigate().to():
        driver.navigate().to("https://www.google.com");

        currentTitle = driver.getTitle();




        // get the tittle of the page

        //  System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("currentTitle = " + currentTitle);

       //   driver.wait();

        // Get the current url using selenium
        currenturl =   driver.getCurrentUrl();


        System.out.println("currenturl = " + currenturl);

       //this will close the currently opened window
         driver.close();


         // this will close all of the opened windows

        driver.quit();


    }
}
