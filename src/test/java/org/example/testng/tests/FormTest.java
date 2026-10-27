package org.example.testng.tests;

import org.example.pom.DemoqaForm;
import org.example.utils.SeleniumDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTest {

    public static WebDriver driver;
    public static String URL = "https://demoqa.com/automation-practice-form";

    public static String First_Name = "Nadejda";
    public static String Last_Name = "Antonii";

    @BeforeTest
    public void beforeTest(){
        driver = SeleniumDrivers.getAutoDriver();
    }

    @Test
    public void formTest(){
        System.out.println("Start");
        driver.get(URL);
        driver.manage().window().maximize();
        DemoqaForm form = new DemoqaForm(driver);
        form.setFirstName(First_Name);
        form.setLastName(Last_Name);
    }

    @AfterTest

    public void tearDown(){
        driver.quit();
    }
}
