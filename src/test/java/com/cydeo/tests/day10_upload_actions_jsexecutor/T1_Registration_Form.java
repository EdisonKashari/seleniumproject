package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_Registration_Form {

    @Test
    public void registration_form_test(){
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.cssSelector("input[name='firstname']"));
        inputFirstName.sendKeys(firstName);
        //4. Enter last name
        String lastName = faker.name().lastName();
        WebElement inputLastName = Driver.getDriver().findElement(By.cssSelector("input[name='lastname']"));
       inputLastName.sendKeys(lastName);

        //5. Enter username
        String userName = faker.bothify("helpdesk###");
        WebElement inputUserName = Driver.getDriver().findElement(By.cssSelector("input[name='username']"));
        inputUserName.sendKeys(userName);

        //6. Enter email address
        WebElement inputEmailAddress = Driver.getDriver().findElement(By.cssSelector("input[name='email']"));
        inputEmailAddress.sendKeys(faker.internet().emailAddress());


        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.cssSelector("input[name='password']"));
        inputPassword.sendKeys(userName+"@gmail.com");
        //8. Enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.cssSelector("input[name='phone']"));
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));
        //9. Select a gender from radio buttons
        WebElement inputGender = Driver.getDriver().findElement(By.cssSelector("input[value='male']"));
        inputGender.click();
        //10. Enter date of birth
        WebElement inputBirthday= Driver.getDriver().findElement(By.cssSelector("input[name='birthday']"));
        inputBirthday.sendKeys(faker.numerify("05/09/19##"));

        //11. Select Department/Office

        Select departmentOffice = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));

        departmentOffice.selectByIndex(1);
        //12. Select Job Title

        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("QA");
        //13. Select programming language from checkboxes
        WebElement selectProgrammingLanguage = Driver.getDriver().findElement(By.xpath("//*[@id='inlineCheckbox2']"));
        selectProgrammingLanguage.click();
        //14. Click to sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//*[@id='wooden_spoon']"));
        signUpButton.click();
        //15. Verify success message “You’ve successfully completed registration.” is
        WebElement verify = Driver.getDriver().findElement(By.xpath("//p"));

        String expectedTitle = "You've successfully completed registration!";
        String actualTitle = verify.getText();

        assertEquals(expectedTitle,actualTitle);
        //displayed.
    }


}
/**
 * TC#1: Registration form confirmation
 * Note: Use JavaFaker OR read from configuration.properties file when possible.
 * 1. Open browser
 * 2. Go to website: https://practice.cydeo.com/registration_form
 * 3. Enter first name
 * 4. Enter last name
 * 5. Enter username
 * 6. Enter email address
 * 7. Enter password
 * 8. Enter phone number
 * 9. Select a gender from radio buttons
 * 10. Enter date of birth
 * 11. Select Department/Office
 * 12. Select Job Title
 * 13. Select programming language from checkboxes
 * 14. Click to sign up button
 * 15. Verify success message “You’ve successfully completed registration.” is
 * displayed.
 *
 *
 * Note:
 * 1. Use new Driver utility class and method
 * 2. User JavaFaker when possible
 * 3. User ConfigurationReader when it makes sense
 */