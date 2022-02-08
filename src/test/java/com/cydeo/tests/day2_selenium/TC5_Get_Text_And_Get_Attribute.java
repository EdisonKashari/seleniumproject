package com.cydeo.tests.day2_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_Get_Text_And_Get_Attribute {
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        //Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        WebElement headerText = driver.findElement(By.tagName("h2"));

        String expectedHeaderText = "Registration form";

        String actualHeaderText = headerText.getText();

        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text verifiction Passed");
        }else {
            System.out.println("Header text verification Failed");
        }

        WebElement firstNameInput = driver.findElement(By.name("firstname"));

        String exceptedPlaceHolder = "first name";
        String actulPlaceHolder = firstNameInput.getAttribute("placeholder");

        if (actualHeaderText.equals(expectedHeaderText)) {

            System.out.println("Place holder text verification PASSED!");
        }else {
            System.out.println("Place holder text verification FAILED");
        }

        driver.close();

    }
}
/*
TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
Expected: first name
 */