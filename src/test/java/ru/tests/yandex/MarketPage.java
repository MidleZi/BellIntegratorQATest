package ru.tests.yandex;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MarketPage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//li[@data-department=\"Компьютеры\"]//a[contains(text(), 'Компьютеры')]")
    WebElement computerButton;

    @FindBy(xpath = "//a[contains(text(), 'Ноутбуки')]")
    WebElement notebooksButton;

    @FindBy(xpath = "//a[contains(text(), 'Планшеты')]")
    WebElement tabletsButton;


    public MarketPage(WebDriver driver){
        this.driver = driver;
    }


}
