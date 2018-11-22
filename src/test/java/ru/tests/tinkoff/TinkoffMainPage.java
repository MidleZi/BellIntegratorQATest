package ru.tests.tinkoff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.By.xpath;


public class TinkoffMainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(),'Платежи')]")
    private WebElement payments;

    public TinkoffMainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void open(){
        driver.get("https://www.tinkoff.ru");
    }

    public void paymentsButtonClick(){
        payments.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[text()='ЖКХ']")));
    }
}
