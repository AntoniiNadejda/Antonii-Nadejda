package org.example.testng.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pom.DemoqaForm;
import org.example.pom.newSubmitForm;
import org.example.utils.SeleniumDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTest {

    public static WebDriver driver;
    public static String URL = "https://demoqa.com/automation-practice-form";

    private static final Logger logger = LogManager.getLogger(FormTest.class);

    public static String First_Name = "Nadejda";
    public static String Last_Name = "Antonii";
    public static String email = "anntoniinadya@gmail.com";
    public static String gender = "Female";
    public static String phone = "0611305430";
    public static String date = "20 Oct 2026";
    public static String subject = "Arts";
    public static String hobby = "Sports";
    public static String state = "Rajasthan";
    public static String city = "Jaipur";


    @BeforeTest
    public void beforeTest(){
        driver = SeleniumDrivers.getAutoDriver();
    }

    @Test
    public void formTest() throws InterruptedException {
        logger.info("Start Test");
        driver.get(URL);
        driver.manage().window().maximize();
        DemoqaForm form = new DemoqaForm(driver);
        form.setFirstName(First_Name);
        form.setLastName(Last_Name);
        form.setEmail(email);
        form.setGender(gender);
        form.setPhone(phone);
        form.setDate(date);
        form.setSubject(subject);
        form.setHobby(hobby);
        form.setState(state);
        form.setCity(city);
        form.Submit();
        newSubmitForm submitForm = new newSubmitForm(driver);

        String actualFirstName = submitForm.getFirstName();
        String expectedFirstName = First_Name;
        Assert.assertEquals(actualFirstName, expectedFirstName);

        String actualLastName = submitForm.getLastName();
        String expectedLastName = Last_Name;
        Assert.assertEquals(actualLastName, expectedLastName);

        String actualEmail = submitForm.getEmail();
        String expectedEmail = email;
        Assert.assertEquals(actualEmail, expectedEmail);

        String actualGender = submitForm.getGender();
        String expectedGender = gender;
        Assert.assertEquals(actualGender, expectedGender);

        String actualPhone = submitForm.getPhone();
        String expectedPhone = phone;
        Assert.assertEquals(actualPhone, expectedPhone);

        String actualDate = submitForm.getDate();
        String expectedDate = date;
        Assert.assertEquals(actualDate, expectedDate);

        String actualSubjects = submitForm.getSubjects();
        String expectedSubjects = subject;
        Assert.assertEquals(actualSubjects, expectedSubjects);

        String actualHobbies = submitForm.getHobbies();
        String expectedHobbies = hobby ;
        Assert.assertEquals(actualHobbies, expectedHobbies);

        String actualState = submitForm.getState();
        String expectedState = state;
        Assert.assertEquals(actualState, expectedState);

        String actualCity = submitForm.getCity();
        String expectedCity = city;
        Assert.assertEquals(actualCity, expectedCity);

        logger.info("Finish Test");
    }

    @AfterTest

    public void tearDown(){
        driver.quit();
    }
}
