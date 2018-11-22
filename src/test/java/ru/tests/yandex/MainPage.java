package ru.tests.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    @FindBy(xpath = "//a[@data-id=\"market\"]")
    private WebElement marketButton;

    public WebElement getMarketButton() {
        return marketButton;
    }

    public void open(){
        driver.manage().window().maximize();
        driver.get("https://yandex.ru");
    }
}
