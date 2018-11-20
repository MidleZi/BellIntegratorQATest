package ru.tests.ozon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OzonMyPersonalPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-test-id=\"header-search-go\"]")
    private WebElement searchButton;

    public OzonMyPersonalPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void search(String search, By wait1) {
        searchField.clear();
        searchField.sendKeys(search);
        wait.until(ExpectedConditions.visibilityOfElementLocated(wait1));
        searchButton.click();


    }
}
