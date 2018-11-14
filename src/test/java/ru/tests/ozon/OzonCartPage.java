package ru.tests.ozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OzonCartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class=\"eMyOzon_Item mCart jsPanelCart\"]/a")
    private WebElement cartButton;

    public OzonCartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }


    private List<WebElement> cartCleanButtons;

    public void clearCart() {

        cartCleanButtons = driver.findElements(By.xpath("//div[@class=\"bIconButton mRemove mGray jsRemoveAll\"]"));
        System.out.println("cartCleanButtons " + cartCleanButtons.size());

        /**не удаляет из корзины (не кликаются кнопки) разобраться с псевдоэлементами*/
        for (int i = 1; i < cartCleanButtons.size(); i++) {
            cartCleanButtons.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"eCartControls_infoDate\"]")));
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

    public boolean cartEmpty(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"eMyOzon_Item mCart jsPanelCart\"]/a")));
        cartButton.click();
        WebElement title = driver.findElement(By.xpath("//span[@class=\"jsInnerContentpage_title\"]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"jsInnerContentpage_title\"]")));
        System.out.println(title.getText());
        return title.getText().equals("Корзина пуста");
    }
}
//div[@class=\"ePanelLinks_term jsOption  jsClearTilesFromStorage jsLogOff jsBottomPart\"]