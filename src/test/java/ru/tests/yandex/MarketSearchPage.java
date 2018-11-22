package ru.tests.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MarketSearchPage {

    @FindBy(xpath = "//input[@name=\"Цена до\"]")
    WebElement maxPriceField;

    @FindBy(xpath = "//input[@name=\"Цена от\"]")
    WebElement minPriceField;

    @FindBy(xpath = "//div[@class=\"n-snippet-card2__title\"]")
    List<WebElement> cardList;

    @FindBy(xpath = "//input[@id=\"header-search\"]")
    WebElement headerSearch;

    private WebElement firstElementInList;
    private String firstElementInListName;


    //JS for checkbox on/off
    public void selectCheckBox(String name, WebDriver driver) {
        String checkXpath = "//input[@name=\"Производитель " + name + "\"]";
        WebElement manufacture = driver.findElement(By.xpath(checkXpath));


        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", manufacture);
    }

    public WebElement getFirstElementInList() {
        return firstElementInList;
    }

    public void setFirstElementInList(WebElement firstElementInList) {
        this.firstElementInList = firstElementInList;
    }

    public String getFirstElementInListName() {
        return firstElementInListName;
    }

    public void setFirstElementInListName(String firstElementInListName) {
        this.firstElementInListName = firstElementInListName;
    }
}
