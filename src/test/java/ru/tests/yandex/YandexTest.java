package ru.tests.yandex;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import ru.tests.WebDriverSettings;

public class YandexTest extends WebDriverSettings {



    @Test
    public void yandexTest1(){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        MarketPage marketPage = PageFactory.initElements(driver, MarketPage.class);
        MarketSearchPage marketSearchPage = PageFactory.initElements(driver, MarketSearchPage.class);
        Actions actions = new Actions(driver);

        //Шаг 1, Шаг 2
        mainPage.open();

        //Шаг 3
        mainPage.getMarketButton().click();

        //Шаг 4, Шаг 5
        waiting(driver, marketPage.computerButton);
        actions.moveToElement(marketPage.computerButton).perform();
        waiting(driver, marketPage.notebooksButton);
        marketPage.notebooksButton.click();

        //Шаг 6
        waiting(driver, marketSearchPage.maxPriceField);
        marketSearchPage.maxPriceField.sendKeys("30000");

        //Шаг 7 Шаг 8
        marketSearchPage.selectCheckBox("HP", driver);
        marketSearchPage.selectCheckBox("Lenovo", driver);

        //Шаг 9
        Assert.assertTrue(marketSearchPage.cardList.size() == 48);

        //Шаг 10
        marketSearchPage.setFirstElementInList(marketSearchPage.cardList.get(0));
        marketSearchPage.setFirstElementInListName(marketSearchPage.cardList.get(0).getText());

        //Шаг 11
        marketSearchPage.headerSearch.sendKeys(marketSearchPage.getFirstElementInListName());
        driver.findElement(By.xpath("//span[@class=\"search2__button\"]"));

        //Шаг 12
        Assert.assertTrue(marketSearchPage.cardList.get(0).getText().equals(marketSearchPage.getFirstElementInListName()));


    }

    @Test
    public void yandexTest2(){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        MarketPage marketPage = PageFactory.initElements(driver, MarketPage.class);
        MarketSearchPage marketSearchPage = PageFactory.initElements(driver, MarketSearchPage.class);
        Actions actions = new Actions(driver);

        //Шаг 1, Шаг 2
        mainPage.open();

        //Шаг 3
        mainPage.getMarketButton().click();

        //Шаг 4, Шаг 5
        waiting(driver, marketPage.computerButton);
        actions.moveToElement(marketPage.computerButton).perform();
        waiting(driver, marketPage.tabletsButton);
        marketPage.tabletsButton.click();

        //Шаг 6, Шаг 7
        waiting(driver, marketSearchPage.minPriceField);
        marketSearchPage.minPriceField.sendKeys("25000");
        waiting(driver, marketSearchPage.maxPriceField);
        marketSearchPage.maxPriceField.sendKeys("30000");

        //Шаг 8 Шаг 9
        marketSearchPage.selectCheckBox("ASUS", driver);
        marketSearchPage.selectCheckBox("Huawei", driver);

        //Шаг 10
        Assert.assertTrue(marketSearchPage.cardList.size() == 48);

        //Шаг 11
        marketSearchPage.setFirstElementInList(marketSearchPage.cardList.get(0));
        marketSearchPage.setFirstElementInListName(marketSearchPage.cardList.get(0).getText());

        //Шаг 12
        marketSearchPage.headerSearch.sendKeys(marketSearchPage.getFirstElementInListName());
        driver.findElement(By.xpath("//span[@class=\"search2__button\"]"));

        //Шаг 13
        Assert.assertTrue(marketSearchPage.cardList.get(0).getText().equals(marketSearchPage.getFirstElementInListName()));
    }
}
