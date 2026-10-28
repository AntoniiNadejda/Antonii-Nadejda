package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class newSubmitForm {
    public static WebDriver driver;

    public newSubmitForm (WebDriver driverParam){
        driver = driverParam;
    }

    public String getValue(String nameParam){
        return driver.findElement(By.xpath("//table//tr//td[text()='"+nameParam+"']/../td[2]")).getText();
    }
    public String getStudentName(){
        return getValue("Student Name");
    }
}
