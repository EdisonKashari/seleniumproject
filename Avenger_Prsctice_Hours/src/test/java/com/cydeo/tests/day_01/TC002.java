package com.cydeo.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002 {
    public static void main(String[] args) {
        // 1- Setup the "browser driver"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();







        //- Go to "https://app.vytrack.com/user/login"
        driver.get("https://app.vytrack.com/user/login");

       String curentURL= driver.getCurrentUrl();

       String EcpextedURL = "vytrack";

        //- Verify the url contains "vytrack"

      //  if (curentURL.contains())


        //- Verify the title contains "Login"


        //- Verify the label "Login"

        //login


        //- Verify the message "Invalid user name or password"


    }
}
