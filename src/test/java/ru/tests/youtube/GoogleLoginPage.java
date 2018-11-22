package ru.tests.youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Далее']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement passField;

    public void nextButtonClick() {
        nextButton.click();
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPassField() {
        return passField;
    }

}
