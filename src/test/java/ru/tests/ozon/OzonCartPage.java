package ru.tests.ozon;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OzonCartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class=\"bIconButton mRemove mGray jsRemoveAll\"]")
    private WebElement cartDeleteAllButton;

    public OzonCartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void clearCart() {
        while(!cartEmpty()){
            try {
                cartDeleteAllButton.click();
            }
            catch(WebDriverException ex) {
                System.out.println("Не нашел элемент при удалении! Продолжает щелкать");
                clearCart();
            }
        }
    }

    public void signOut(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"jsUserMenuWrap\"]")));
        Actions action = new Actions(driver);
        WebElement elem = driver.findElement(By.xpath("//div[@class=\"eMyOzon_ItemWrap jsQuickPanelUserMenu\"]"));
        action.moveToElement(elem).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"ePanelLinks_term jsOption  jsClearTilesFromStorage jsLogOff jsBottomPart\"]")));
        driver.findElement(By.xpath("//div[@class=\"ePanelLinks_term jsOption  jsClearTilesFromStorage jsLogOff jsBottomPart\"]")).click();
    }

    public boolean cartEmpty() throws NoSuchElementException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"jsInnerContentpage_title\"]")));
        WebElement title = driver.findElement(By.xpath("//span[@class=\"jsInnerContentpage_title\"]"));
        System.out.println(title.getText());
        return title.getText().equals("Корзина пуста");
    }
}