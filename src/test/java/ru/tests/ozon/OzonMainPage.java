package ru.tests.ozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;

public class OzonMainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class=\"ePanelLinks_term jsOption  jsScores jsWallet jsBottomPart\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[text()=' Мой OZON']")
    private WebElement itemBottom;


    public OzonMainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void open(){
        driver.get("https://www.ozon.ru/");
    }

    public void loginButtonClick() {

        Actions action = new Actions(driver);
        action.moveToElement(itemBottom).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@class=\"ePanelLinks_term jsOption  jsScores jsWallet jsBottomPart\"]")));
        loginButton.click(); //кликаем на кнопку "Личный кабинет"
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//a[@class=\"link-base\"]")));
    }


}
