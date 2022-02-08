package com.cydeo.tests.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement header = driver.findElement(By.tagName("h3"));

        String actualHeader = header.getText();

        String expectedHeader = "Log in to ZeroBank";

        if (actualHeader.equals(expectedHeader)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

driver.close();

        stopWatch.stop();
        double totalTime = stopWatch.getTime();
        System.out.println("Total execution time: "+totalTime/1000.0+" seconds");
    }
}
/*TC #2: Zero Bank header verification
        1. Open Chrome browser
        2. Go to http://zero.webappsecurity.com/login.html
        3. Verify header text
        Expected: “Log in to ZeroBank” */