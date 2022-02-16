package com.cydeo.tests.Adam_HomeWork;

import com.cydeo.utilitiesAdam.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_01_HomeDisplayed {
    public static void main(String[] args) throws InterruptedException {
        //TC:1 As a user I should be able to see Home is displayed
        // //1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        // //3-verify Home is displayed
        Thread.sleep(3000);
        // WebElement home = driver.findElement(By.xpath("//a[@aria-current='page']"));
          WebElement home1 = driver.findElement(By.cssSelector("a[aria-current='page']"));
       // WebElement home1 = driver.findElement(By.xpath("//*[@id=\"menu-item-844\"]/a"));

        System.out.println("home1.isDisplayed() = " + home1.isDisplayed());


        System.out.println(home1.getText());
        if (home1.getText().equals("Home")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
