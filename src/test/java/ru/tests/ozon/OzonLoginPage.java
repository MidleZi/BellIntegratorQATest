package ru.tests.ozon;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;

public class OzonLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement passField;

    @FindBy(xpath = "//button[@type=\"button\"]")
    private WebElement authenticationButton;

    @FindBy(xpath = "//input[@id=\"CapabilityAgree\"]")
    private WebElement checkBoxCapabilityAgree;

    @FindBy(xpath = "//a[@class=\"link-base\"]")
    private WebElement emailEnterButton;

    public OzonLoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void changeToLoginForEmail(){
        emailEnterButton.click();
    }

    public void signInEmail(String login, String pass){

        loginField.sendKeys(login);
        passField.sendKeys(pass);
        authenticationButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//input[@type=\"text\"]")));
    }


    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPassField() {
        return passField;
    }

    public WebElement getAuthenticationButton() {
        return authenticationButton;
    }

    public WebElement getCheckBoxCapabilityAgree() {
        return checkBoxCapabilityAgree;
    }

    public WebElement getEmailEnterButton() {
        return emailEnterButton;
    }


}
