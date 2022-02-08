package com.cydeo.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTask3 {
    private static WebDriver driver;
    public static void main(String[] args) {

        urlGoogle("https://www.google.com/");

        titleVerification("Google");

        etsyUrls("https://www.etsy.com/");

        titleVerification("Etsy");

    }

    private static void etsyUrls(String etsyUrl) {
        driver.get(etsyUrl);
    }

    private static void titleVerification(String expctedResult) {
        String actualTitle = driver.getTitle();
        String newTitle = driver.getTitle();
        String oldTitle = "Google";
        if (newTitle.equals(oldTitle)){
            System.out.println("It's in a ggogle page");
        }else {
            System.out.println("It is not in a google page");
        }


        if (actualTitle.contains(expctedResult)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
    }

    private static void urlGoogle(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
}
//Setup the "browser driver"

//Go to "https://www.google.com/"

//Verify the title contains "Google"

//Navigate to "https://www.etsy.com/"

//Verify not in google page

//Verify the title  contains "Etsy"