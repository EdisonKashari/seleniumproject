package com.cydeo.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTask {
   private static WebDriver driver;
    public static void main(String[] args) {


        forSeleniumURL("https://www.selenium.dev");

        titleVerification("Selenium");

    }

    private static void titleVerification(String expectedTitle) {
        String actulTitle = driver.getTitle();
        if (actulTitle.contains(expectedTitle)){
            System.out.println("PASSED");
        }else {
            System.out.println("Failed");
        }

    }

    private static void forSeleniumURL(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.get(url);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
//Setup the "browser driver"

//Go to "https://www.selenium.dev"

//Verify the title contains "Selenium"