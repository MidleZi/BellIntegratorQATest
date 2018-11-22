package ru.tests.ozon;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzonSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Корзина']")
    private WebElement cartButton;

    public OzonSearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void addToCart(By by, String id, int i){
        if(driver.findElement(By.xpath("//div[@data-key=\"" + i + "\"]//button/span")).getText().equals("В корзину")) {
            driver.findElement(by).click();
            System.out.println("invite in cart " + "//div[@data-key=\"" + i + "\"]/div. id = " + id);
        }
    }

    public void cartButtonClick(){
        try {
            cartButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"eCartControls_infoDate\"]")));
        }
        catch (NoSuchElementException ex){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Корзина')]")));
            cartButton.click();
        }
    }
}
