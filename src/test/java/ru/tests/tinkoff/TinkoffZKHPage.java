package ru.tests.tinkoff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;

public class TinkoffZKHPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[@aria-label='Москве']")
    private WebElement regionName;

    @FindBy(xpath = "//div[@data-qa-file='FadeText'][contains(text(), 'ЖКУ-Москва')]")
    private WebElement zkuMoscow;

    @FindBy(xpath = "//span[@data-qa-file='Tab'][contains(text(), 'Оплатить ЖКУ в Москве')]")
    private WebElement zkuMoscowPay;

    @FindBy(xpath = "//button")
    private WebElement payButton;

    @FindBy(xpath = "//a[contains(text(),'Платежи')]")
    private WebElement payments;

    public TinkoffZKHPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }


    public void paymentsButtonClick(){
        payments.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[text()='ЖКХ']")));
    }

    public String getRegionName(){
        return regionName.getText();
    }

    public void zkuMoscowButtonClick() {
        zkuMoscow.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//span[@data-qa-file='Tab'][contains(text(), 'Оплатить ЖКУ в Москве')]")));
    }

    public void zkuMoscowPayClick(){
        zkuMoscowPay.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//button")));
    }

    public void payButtonClick(){
        payButton.click();
    }

    public String getFieldFormName(By by){
        return driver.findElement(by).getText();
    }


}
