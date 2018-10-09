package ru.tests.ozon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.tests.WebDriverSettings;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class OzonTest  extends WebDriverSettings {

    @Test
    public void ozonTest(){

        //Шаг №1
        driver.get("http://www.ozon.ru/");
        waiting(driver, By.xpath("//div[@class=\"eMyOzon_Item mUser\"]")); //ждем загрузку элемента "Мой OZON"

        Actions action = new Actions(driver);
        WebElement elem = driver.findElement(By.xpath("//div[@class=\"eMyOzon_Item mUser\"]"));
        action.moveToElement(elem);
        action.perform();
        waiting(driver, By.xpath("//div[@class=\"ePanelLinks_term jsOption  jsScores jsWallet jsBottomPart\"]"));
        driver.findElement(By.xpath("//div[@class=\"ePanelLinks_term jsOption  jsScores jsWallet jsBottomPart\"]")).click(); //кликаем на кнопку "Личный кабинет"
        waiting(driver, By.xpath("//input[@id='Login']"));

        //Шаг №2
        driver.findElement(By.xpath("//input[@id='Login']")).sendKeys("gigilom@yandex.ru");
        driver.findElement(By.xpath("//input[@id='Passw']")).sendKeys("123123");


        try {
            driver.findElement(By.xpath("//input[@id=\"Authentication\"]")).click();
        }
        catch (NoSuchElementException e){
            driver.findElement(By.xpath("//input[@id=\"CapabilityAgree\"]")).click();
            driver.findElement(By.xpath("//input[@id=\"Authentication\"]")).click();
        }
        waiting(driver, By.xpath("//input[@id=\"SearchText\"]"));

        //Шаг №3
        driver.findElement(By.xpath("//input[@id=\"SearchText\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"SearchText\"]")).sendKeys("iPhone");
        /**не кликается кнопка*/
        driver.findElement(By.xpath("//div[@class=\"bFlatButton mSearchButton\"]")).click();
        waiting(driver, By.xpath("//div[@data-v-4946680f]/div"));



        //Шаг№4
        List<String> invitelist = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@data-key]"));

        for (int i = 0; i < elementList.size(); i++) {
            if((i%2)!=0 || i == 1) {
                String id = driver.findElement(By.xpath("//div[@data-key=\"" + i + "\"]/div")).getAttribute("id");
                if(driver.findElement(By.xpath("//div[@data-key=\"" + i + "\"]//button/span")).getText().equals("В корзину")) {
                    invitelist.add(id);
                    driver.findElement(By.xpath("//div[@data-key=\"" + i + "\"]//button/span")).click();
                    System.out.println("invite in cart " + "//div[@data-key=\"" + i + "\"]/div. id = " + invitelist.get(invitelist.size()-1));
                    System.out.println(id);
                }
            }
        }


        //Шаг №5

        for(int i = 0; i < invitelist.size(); i++){
            assertNotNull(driver.findElements(By.xpath("//div[@class=\"eCartSplitItems\"]//div[@data-id=\"" + invitelist.get(i) + "\"]")));
        }

        //driver.findElement(By.xpath("//div[@data-test-id=\"header-cart\"]/a")).click();

        waiting(driver, By.xpath("//div[@class=\"eCartControls_infoDate\"]"));

        //Шаг №6

        List<WebElement> cartclean = driver.findElements(By.xpath("//div[@class=\"bIconButton mRemove mGray jsRemoveAll\"]"));

        /**не удаляет из корзины (не кликаются кнопки)*/
        for (int i = 1; i < cartclean.size(); i++) {
            cartclean.get(i).click();
            waiting(driver, By.xpath("//div[@class=\"eRemovedCartItems_removeAll jsRemoveAll\"]"));
            driver.findElement(By.xpath("//div[@class=\"eRemovedCartItems_removeAll jsRemoveAll\"]")).click();
        }

        //Шаг №7

        waiting(driver, By.xpath("//div[@class=\"eMyOzon_Item_Bottom bTextLink\"]"));
        elem = driver.findElement(By.xpath("//div[@class=\"eMyOzon_Item_Bottom bTextLink\"]"));
        action.moveToElement(elem);
        action.perform();
        waiting(driver, By.xpath("//div[@class=\"ePanelLinks_term jsOption  jsScores jsWallet jsBottomPart\"]"));
        driver.findElement(By.xpath("//div[@class=\"ePanelLinks_term jsOption  jsClearTilesFromStorage jsLogOff jsBottomPart\"]")).click();

        //Шаг №8

        waiting(driver, By.xpath("//div[@class=\"eMyOzon_Item mUser\"]"));

        elem = driver.findElement(By.xpath("//div[@class=\"eMyOzon_Item mUser\"]"));
        action.moveToElement(elem);
        action.perform();
        waiting(driver, By.xpath("//div[@class=\"ePanelLinks_term jsOption  jsScores jsWallet jsBottomPart\"]"));
        driver.findElement(By.xpath("//div[@class=\"ePanelLinks_term jsOption  jsScores jsWallet jsBottomPart\"]")).click(); //кликаем на кнопку "Личный кабинет"
        waiting(driver, By.xpath("//input[@id='Login']"));
        driver.findElement(By.xpath("//input[@id='Login']")).sendKeys("gigilom@yandex.ru");
        driver.findElement(By.xpath("//input[@id='Passw']")).sendKeys("123123");
        try {
            driver.findElement(By.xpath("//input[@id=\"Authentication\"]")).click();
        }
        catch (NoSuchElementException e){
            driver.findElement(By.xpath("//input[@id=\"CapabilityAgree\"]")).click();
            driver.findElement(By.xpath("//input[@id=\"Authentication\"]")).click();
        }
        waiting(driver, By.xpath("//div[@class=\"eMyOzon_Item mCart jsPanelCart\"]/a"));

        //Шаг №9
        driver.findElement(By.xpath("//div[@class=\"eMyOzon_Item mCart jsPanelCart\"]/a")).click();
        waiting(driver, By.xpath("//span[@class=\"jsInnerContentpage_title\"]"));
        System.out.println(driver.findElement(By.xpath("//span[@class=\"jsInnerContentpage_title\"]")).getText());
        assertTrue(driver.findElement(By.xpath("//span[@class=\"jsInnerContentpage_title\"]")).getText().equals("Корзина пуста"));
    }
}
