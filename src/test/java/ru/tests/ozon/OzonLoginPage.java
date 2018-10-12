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

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='Passw']")
    private WebElement passField;

    @FindBy(xpath = "//input[@id=\"Authentication\"]")
    private WebElement authenticationButton;

    @FindBy(xpath = "//input[@id=\"CapabilityAgree\"]")
    private WebElement checkBoxCapabilityAgree;

    public OzonLoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }


    public void signIn(String login, String pass){
        loginField.sendKeys(login);
        passField.sendKeys(pass);

        try {
            authenticationButton.click();
        }
        catch (NoSuchElementException e){
            checkBoxCapabilityAgree.click();
            authenticationButton.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//input[@id=\"SearchText\"]")));
    }


}
