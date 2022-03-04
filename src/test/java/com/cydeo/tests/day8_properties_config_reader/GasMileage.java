package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GasMileage {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        // 1. Add a new class GasMileageCalculatorTest
        // 2. Go to https://www.calculator.net
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.calculator.net");

    }

    @Test
    public void gasMileageCalculator() {
        //3. Search for “gas mileage” using search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage");
        //4. Click on the “Gas Mileage Calculator” link
        driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']")).click();
        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”

        String expectedResult = "Gas Mileage Calculator";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult, actualResult);
        //b. “Gas Mileage Calculator” label is displayed
        WebElement gasMileageCalculator = driver.findElement(By.xpath("//h1"));
        String actualText = gasMileageCalculator.getText();
        String expectedText = "Gas Mileage Calculator";

        Assert.assertEquals(actualText, expectedText);
        //6. Locate, clear and type “7925” into “Current odometer” field

        WebElement currentOdometer = driver.findElement(By.xpath("//input[@id='uscodreading']"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");
        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previowsOdometer = driver.findElement(By.xpath("//input[@id='uspodreading']"));
        previowsOdometer.clear();
        previowsOdometer.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded = driver.findElement(By.xpath("//input[@id='usgasputin']"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = driver.findElement(By.xpath("//input[@id='usgasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        //10. Click on Calculate button
        driver.findElement(By.xpath("//input[@style='margin-top:10px;'][1]")).click();

        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”

        WebElement verifyText = driver.findElement(By.xpath("//p//b"));
        String mpgText = verifyText.getText();
        String expectedMpgText = "23.44 mpg";
        Assert.assertEquals(mpgText, expectedMpgText);

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }
}
