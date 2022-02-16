package com.cydeo.tests.day5_selenium;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {
    @Test (priority = 1)
    public void test1(){
        System.out.println("Test one is running...");
        //ASSERT EQUALS : compare 2 of the same things

        String actual = " apple";
        String expected = " apple";

        Assert.assertTrue(actual==expected);

    }
    @Test (priority = 2)
    public void test2(){
        System.out.println("Test two is running...");


    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("---> BeforeClass is running");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("--->AfterClass is running");
    }
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("---> BeforeMethods running");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is Running");
    }
}
