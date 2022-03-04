package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.SmartBearLogin;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearJavaFaker {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearLogin.loginSmartBear(driver);



    }
    @Test
    public void javaFaker(){
        //6. Click on Order
        driver.findElement(By.xpath("//a[.='Order']")).click();
        //7. Select familyAlbum from product, set quantity to 2
     WebElement quantity =  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.click();
        quantity.sendKeys(Keys.BACK_SPACE);
        quantity.sendKeys("2");
        //8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@onclick='productsChanged(); return false;']")).click();

        //9. Fill address Info with JavaFaker
        // Generate: name, street, city, state, zip code

        Faker faker = new Faker();
        String name = faker.name().firstName();
        String street = faker.address().streetName();
        String city = faker.address().cityName();
        String state = faker.address().state();
        String zipCode = faker.number().digits(5);




         driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(name);
         driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys(street);
         driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(city);
         driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(state);
         driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(zipCode);

        //10. Click on “visa” radio button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();

        String cardNumber = faker.number().digits(16);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(cardNumber);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys("05/25");
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

        WebElement textProvided = driver.findElement(By.xpath("//strong"));


        String expectedResult = "New order has been successfully added.";
        String actualResult = textProvided.getText();

        Assert.assertEquals(expectedResult,actualResult);


    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(3);
        driver.close();
    }
}
//TC#2: Smartbear software order placing
//1. Open browser
//2. Go to website:
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3. Enter username: “Tester”
//4. Enter password: “test”
//5. Click on Login button

//7. Select familyAlbum from product, set quantity to 2
//8. Click to “Calculate” button
//9. Fill address Info with JavaFaker
//• Generate: name, street, city, state, zip code
//10. Click on “visa” radio button
//11. Generate card number using JavaFaker
//12. Click on “Process”
//13. Verify success message “New order has been successfully added.”