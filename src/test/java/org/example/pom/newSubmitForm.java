package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class newSubmitForm {
    public static WebDriver driver;

    public newSubmitForm (WebDriver driverParam){
        driver = driverParam;
    }

    public String getValue(String nameParam) {
        return driver.findElement(By.xpath("//table//tr[td[1]='" + nameParam + "']/td[2]")).getText();
    }
    public String getFirstName() {
        return getValue("Student First Name");
    }

    public String getLastName() {
        return getValue("Student Last Name");
    }

    public String getEmail() {
        return getValue("Student Email");
    }

    public String getGender() {
        return getValue("Gender");
    }

    public String getPhone() {
        return getValue("Mobile");
    }

    public String getDate() {
        return getValue("Date of Birth");
    }

    public String getSubjects() {
        return getValue("Subjects");
    }

    public String getHobbies() {
        return getValue("Hobbies");
    }


    public String getState() {
        return getValue("Address");
    }

    public String getCity() {
        return getValue("State and City");
    }
}
