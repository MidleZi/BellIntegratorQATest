package ru.tests.ozon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.tests.WebDriverSettings;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class OzonTest  extends WebDriverSettings {

    private OzonMainPage mainPage;
    private OzonLoginPage loginPage;
    private OzonMyPersonalPage myPersonalPage;
    private OzonSearchPage searchPage;
    private OzonCartPage cartPage;


    @Test
    public void ozonTest(){

        mainPage = PageFactory.initElements(driver, OzonMainPage.class);
        loginPage = PageFactory.initElements(driver, OzonLoginPage.class);
        myPersonalPage = PageFactory.initElements(driver, OzonMyPersonalPage.class);
        searchPage = PageFactory.initElements(driver, OzonSearchPage.class);
        cartPage = PageFactory.initElements(driver, OzonCartPage.class);

        //Шаг №1
        mainPage.open();

        //Шаг №2
        mainPage.loginButtonClick();
        loginPage.signIn("gigilom@yandex.ru", "123123");

        //Шаг №3
        myPersonalPage.search("iPhone", By.xpath("//div[@data-v-4946680f]/div"));

        //Шаг№4
        List<String> invitelist = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@data-key]"));

        for (int i = 0; i < elementList.size(); i++) {
            if((i%2)!=0 || i == 1) {
                String id = driver.findElement(By.xpath("//div[@data-key=\"" + i + "\"]/div")).getAttribute("id");
                    invitelist.add(id);
                    searchPage.addToCart(By.xpath("//div[@data-key=\"" + i + "\"]//button/span"), id, i);
            }
        }

        //Шаг №5
        searchPage.cartButtonClick();
        for(int i = 0; i < invitelist.size(); i++){
            assertNotNull(driver.findElements(By.xpath("//div[@class=\"eCartSplitItems\"]//div[@data-id=\"" + invitelist.get(i) + "\"]")));
        }

        //Шаг №6
        cartPage.clearCart();

        //Шаг №7
      //  driver.findElement(By.xpath("//div[@data-test-id=\"header-cart\"]/a")).click(); //для теста без добавления в корзину (список товаров хранится на сервере, приходится удалять вручную)
      //  waiting(driver, By.xpath("//span[@class=\"jsInnerContentpage_title\"]"));//для теста без добавления в корзину (список товаров хранится на сервере, приходится удалять вручную)
        cartPage.signOut();

        //Шаг №8
        mainPage.loginButtonClick();
        loginPage.signIn("gigilom@yandex.ru", "123123");

        //Шаг №9
        assertTrue(cartPage.cartEmpty());
    }
}
