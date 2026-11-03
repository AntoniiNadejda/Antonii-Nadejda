package org.example.pom;

import org.example.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoqaForm {
    public static WebDriver driver;
    public static JavascriptExecutor js;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='lastName']")
    WebElement lastName;

    @FindBy(css = "#userEmail")
    WebElement email;

    @FindBy(xpath = "//*[@id='userNumber']")
    WebElement phone;

    @FindBy(xpath ="//*[@id='dateOfBirthInput']")
    WebElement date;

    @FindBy(xpath ="//*[@id='subjectsInput']")
    WebElement subject;

    @FindBy(css = "#state")
    WebElement state;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css ="#submit")
    WebElement submit;

    public void scroll2Amount(int deltaY){
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
    }


    public DemoqaForm(WebDriver driverParam) {
        driver = driverParam;
        js = (JavascriptExecutor) driverParam;
        PageFactory.initElements(driverParam, this);
    }

    public void setFirstName(String firstNameParam) {
        firstName.clear();
        firstName.sendKeys(firstNameParam);

    }

    public void setLastName(String lastNameParam) {
        lastName.clear();
        lastName.sendKeys(lastNameParam);
    }

    public void setEmail(String emailParam) {
        email.clear();
        email.sendKeys(emailParam);
    }

    public void setGender(String genderParam) {
        WebElement gender = driver.findElement(By.xpath("//*[@id='genterWrapper']//*[text()='" + genderParam + "']"));
        gender.click();
    }
    public void setPhone(String phoneParam){
        phone.clear();
        phone.sendKeys(phoneParam);
    }
    public void setDate(String dateParam){
        date.sendKeys(Keys.CONTROL, "a");
        date.sendKeys(dateParam);
        date.sendKeys(Keys.ENTER);
    }

    public void setSubject(String subjectParam){
        subject.clear();
        subject.sendKeys(subjectParam);
        subject.sendKeys(Keys.ENTER);
    }
    public void scroll(WebElement el){
        new Actions(driver).scrollToElement(el).perform();
    }

    public void setState(String stateParam) throws InterruptedException {
        WaitUtils.explicitWait(driver, ExpectedConditions.elementToBeClickable(state),10);
        scrollToElement(state);
        scroll2Amount(250);
        Thread.sleep(2000);
        state.click();
        driver.findElement(By.xpath("//*[text()='"+stateParam+"']")).click();
    }


    public void setCity(String cityParam){
        scrollToElement(city);
        city.click();
        driver.findElement(By.xpath("//*[text()='"+cityParam+"']")).click();
    }
    public void setHobby(String hobbyParam){
        WebElement hobby = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']//label[text()='"+hobbyParam+"']"));
        hobby.click();
    }
    public void Submit(){
        submit.click();
    }
    public static void closeAdvert() {
        try {
            js.executeScript("var elem = document.evaluate(\"//*[@id='Ad.Plus-970x250-2']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        }
        catch (Exception ignored) {}
        try {
            js.executeScript("var elem = document.evaluate(\"//footer\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
