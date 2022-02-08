package com.cydeo.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03 {
    private static WebDriver driver;
    public static void main(String[] args) {

        forEachVerificatio("https://www.selenium.dev");

        verificationIfContain("Selenium");

        driver.close();


        //Setup the "browser driver"

        //Go to "https://www.selenium.dev"

        //Verify the title contains "Selenium"
    }

    private static void verificationIfContain(String exceptedWord) {
        String actualWord = driver.getTitle();
        if (actualWord.contains(exceptedWord)){
            System.out.println("PASS");
        }else {
            System.out.println("FAILED");
        }
    }

    private static void forEachVerificatio(String url) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
}
