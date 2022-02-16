package com.cydeo.tests.day5_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T3_RadioButton {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        //3. Click to “Hockey” radio button
       // WebElement hockeyBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        //Locate name sports radio buttons and store them in a List of Web Element

clickAndVerifyRadioButton(driver,"sport","hockey");

         //Loop through the List of WebElement and select matching result hockey
        //4. Verify “Hockey” radio button is selected after clicking.
    }
    private static void clickAndVerifyRadioButton(WebDriver driver,String nameAtribute,String idValue){
        List<WebElement> radioBTN = driver.findElements(By.name(nameAtribute));

        for (WebElement each : radioBTN) {
            String eachId =  each.getAttribute("id");


            if (eachId.equals(idValue)){
                each.click();
                System.out.println(eachId + " is selected : " + each.isSelected());
                break;
            }
        }

    }
}
