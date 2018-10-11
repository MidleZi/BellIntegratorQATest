package ru.tests.tinkoff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;

public class TinkoffPaymentsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='IconWithText__container_3I1bQ']//div[text()='ЖКХ']")
    private WebElement zkh;

    @FindBy(xpath = "//input[@data-qa-file=\"SearchInput\"]")
    private WebElement search;

    @FindBy(xpath = "//span[@data-qa-file=\"Link\"]")
    private WebElement setRegionButton;

    private WebElement find;

    public TinkoffPaymentsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void getZKH(){
        zkh.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@data-qa-file='FadeText'][contains(text(), 'ЖКУ-Москва')]")));
    }

    public void getSearh(String keys, By wait1){
        search.sendKeys(keys);
        wait.until(ExpectedConditions.visibilityOfElementLocated(wait1));
    }


    public void setRegion(By by){
        setRegionButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//input[@data-qa-file=\"SearchInput\"]")));
    }

    public void searchClick(){
        find.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//input[@data-qa-file=\"SearchInput\"]")));
    }

    public void setFind(By by){
        find = driver.findElement(by);
    }

    public WebElement getFind(){
        return find;
    }

    public String getFindElementText(){
        return find.getText();
    }

}
