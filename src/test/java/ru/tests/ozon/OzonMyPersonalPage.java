package ru.tests.ozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OzonMyPersonalPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id=\"SearchText\"]")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class=\"bFlatButton mSearchButton\"]")
    private WebElement searchButton;

    public OzonMyPersonalPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void search(String search, By wait1){
        searchField.clear();
        searchField.sendKeys(search);
        /**не кликается кнопка, разобраться с псевдоэлементами*/
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(wait1));

    }
}
