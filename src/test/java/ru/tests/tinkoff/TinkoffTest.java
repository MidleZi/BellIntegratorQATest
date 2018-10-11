package ru.tests.tinkoff;

import org.junit.*;
import static org.junit.Assert.*;
import static org.openqa.selenium.By.xpath;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import ru.tests.WebDriverSettings;


public class TinkoffTest extends WebDriverSettings {


    @Test
    public void testTinkoff() {

        TinkoffMainPage mainPage = PageFactory.initElements(driver, TinkoffMainPage.class);
        TinkoffPaymentsPage paymentsPage = PageFactory.initElements(driver, TinkoffPaymentsPage.class);
        TinkoffZKHPage zkhPage = PageFactory.initElements(driver, TinkoffZKHPage.class);


        //Шаг №1
        mainPage.open(); //открываем сайт

        // Шаг №2
        mainPage.getPaymentsButton();//жмем на кнопку "Платежи"

        // Шаг №3
        paymentsPage.getZKH(); //жмем на кнопку "ЖКХ"

        //Шаг №4
        assertTrue(zkhPage.getRegionName().equals("Москве"));

        //Шаг №5
        zkhPage.zkuMoscowButton(); //жмем на кнопку "ЖКУ-Москва"
        String zhkumoskvapage = driver.getCurrentUrl(); //сохраняем адрес страницы

        //Шаг №6
        zkhPage.getZkuMoscowPay(); //жмем на кнопку "Оплатить ЖКУ в Москве"

        //Шаг №7
        zkhPage.getPayButtonClick(); //жмем на кнопку "Оплатить"

        assertTrue(zkhPage.getFieldFormName(xpath("//form/div[1]/div/div[2][@data-qa-file=\"UIFormRowError\"]")).equals("Поле обязательное"));//проверяем сообщение об ошибке 1-ого поля
        assertTrue(zkhPage.getFieldFormName(xpath("//form/div[2]/div/div[2][@data-qa-file=\"UIFormRowError\"]")).equals("Поле обязательное"));//проверяем сообщение об ошибке 2-ого поля
        assertTrue(zkhPage.getFieldFormName(xpath("//div[1]/div/div/div[@data-qa-file=\"UIFormRowError\"]")).equals("Поле обязательное"));//проверяем сообщение об ошибке 3-его поля

        // Шаг №8
        zkhPage.getPaymentsButton(); //жмем на кнопку "Платежи";

        //Шаг №9
        paymentsPage.getSearh("ЖКУ-Москва", xpath("//div[@data-qa-file=\"SuggestEntry\"]/div/div[contains(text(), 'ЖКУ-Москва')]"));

        //Шаг №10
        paymentsPage.setFind(xpath("//div[@data-qa-file=\"SuggestEntry\"]/div/div[contains(text(), 'ЖКУ-Москва')]"));
        //Подозреваю, что тут не соответствует заданию, т.к. я ссылаюсь на конкретный элемент, а не на первый элемент страницы, но могу и ошибаться

        //Шаг №11
        assertTrue(paymentsPage.getFindElementText().equals("ЖКУ-Москва"));
        paymentsPage.getFind().click();
        waiting(driver, xpath("//span[@data-qa-file='Tab'][contains(text(), 'Оплатить ЖКУ в Москве')]"));
        assertTrue(zhkumoskvapage.equals(driver.getCurrentUrl()));



        // Шаг №12
        zkhPage.getPaymentsButton(); //жмем на кнопку "Платежи";

        paymentsPage.getZKH(); //жмем на кнопку "ЖКХ"

        //Шаг №13
        paymentsPage.setRegion(xpath("//span[@data-qa-file=\"UILink\"][contains(text(), 'г. Санкт-Петербург')]"));

        //Шаг 14

        try{
            paymentsPage.getSearh("ЖКУ-Москва", xpath("//div[@data-qa-file=\"Text\"][contains(text(), 'Ничего не найдено')]"));
            assertTrue(driver.findElement(xpath("//div[@data-qa-file=\"Text\"][contains(text(), 'Ничего не найдено')]")).getText().equals("Ничего не найдено"));
        }
        catch( TimeoutException | InvalidElementStateException e){
            assertTrue(false);
        }
    }

}