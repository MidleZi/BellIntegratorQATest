package ru.tests.tinkoff;

import org.junit.*;
import static org.junit.Assert.*;
import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.*;
import ru.tests.WebDriverSettings;


public class TinkoffTest extends WebDriverSettings {


    @Test
    public void testTinkoff() {


        //Шаг №1
        driver.get("https://www.tinkoff.ru"); //открываем сайт
        waiting(driver, By.xpath("//a[contains(text(),'Платежи')]"));



        // Шаг №2
        driver.findElements(By.cssSelector("[href=\"/payments/\"]")).get(1).click(); //жмем на кнопку "Платежи"
        waiting(driver, xpath("//div[@class='IconWithText__container_3I1bQ']//div[text()='ЖКХ']"));

        // Шаг №3
        driver.findElement(xpath("//div[@class='IconWithText__container_3I1bQ']//div[text()='ЖКХ']")).click(); //жмем на кнопку "ЖКХ"
        waiting(driver, xpath("//div[@data-qa-file='FadeText'][contains(text(), 'ЖКУ-Москва')]"));


        //Шаг №4
       String region = driver.findElement(xpath("//span[@aria-label='Москве']/span")).getText();
        assertTrue(region.equals("Москве"));

        //Шаг №5
        driver.findElement(xpath("//div[@data-qa-file='FadeText'][contains(text(), 'ЖКУ-Москва')]")).click(); //жмем на кнопку "ЖКУ-Москва"
        waiting(driver, xpath("//span[@data-qa-file='Tab'][contains(text(), 'Оплатить ЖКУ в Москве')]"));
        String zhkumoskvapage = driver.getCurrentUrl();

        //Шаг №6
        driver.findElement(xpath("//span[@data-qa-file='Tab'][contains(text(), 'Оплатить ЖКУ в Москве')]")).click(); //жмем на кнопку "Оплатить ЖКУ в Москве"
        waiting(driver, xpath("//button"));

        //Шаг №7
        driver.findElement(xpath("//button")).click(); //жмем на кнопку "Оплатить"
        String field1 = driver.findElement(xpath("//form/div[1]/div/div[2][@data-qa-file=\"UIFormRowError\"]")).getText(); //проверяем сообщение об ошибке 1-ого поля
        assertTrue(field1.equals("Поле обязательное"));

        String field2 = driver.findElement(xpath("//form/div[2]/div/div[2][@data-qa-file=\"UIFormRowError\"]")).getText(); //проверяем сообщение об ошибке 2-ого поля
        assertTrue(field2.equals("Поле обязательное"));

        String field3 = driver.findElement(xpath("//div[1]/div/div/div[@data-qa-file=\"UIFormRowError\"]")).getText(); //проверяем сообщение об ошибке 3-его поля
        assertTrue(field3.equals("Поле обязательное"));

        // Шаг №8
        driver.findElement(xpath("//a[contains(text(),'Платежи')]")).click(); //жмем на кнопку "Платежи"
        waiting(driver, xpath("//input[@data-qa-file=\"SearchInput\"]"));

        //Шаг №9
        driver.findElement(xpath("//input[@data-qa-file=\"SearchInput\"]")).sendKeys("ЖКУ-Москва");
        waiting(driver, xpath("//div[@data-qa-file=\"SuggestEntry\"]/div/div[contains(text(), 'ЖКУ-Москва')]"));

        //Шаг №10
        WebElement find = driver.findElement(xpath("//div[@data-qa-file=\"SuggestEntry\"]/div/div[contains(text(), 'ЖКУ-Москва')]"));
        String findtext = find.getText();
        //Подозреваю, что тут не соответствует заданию, т.к. я ссылаюсь на конкретный элемент, а не на первый элемент страницы, но могу и ошибаться

        //Шаг №11
        assertTrue(findtext.equals("ЖКУ-Москва"));
        find.click();
        waiting(driver, xpath("//span[@data-qa-file='Tab'][contains(text(), 'Оплатить ЖКУ в Москве')]"));
        assertTrue(zhkumoskvapage.equals(driver.getCurrentUrl()));



        // Шаг №12
        driver.findElement(xpath("//a[contains(text(),'Платежи')]")).click(); //жмем на кнопку "Платежи"
        waiting(driver, xpath("//div[@class='IconWithText__container_3I1bQ']//div[text()='ЖКХ']"));

        driver.findElement(xpath("//div[@class='IconWithText__container_3I1bQ']//div[text()='ЖКХ']")).click(); //жмем на кнопку "ЖКХ"
        waiting(driver, xpath("//span[@data-qa-file=\"Link\"]"));

        //Шаг №13
        driver.findElement(xpath("//span[@data-qa-file=\"Link\"]")).click();
        driver.findElement(xpath("//span[@data-qa-file=\"UILink\"][contains(text(), 'г. Санкт-Петербург')]")).click();
        waiting(driver, xpath("//input[@data-qa-file=\"SearchInput\"]"));

        //Шаг 14
        driver.findElement(xpath("//input[@data-qa-file=\"SearchInput\"]")).sendKeys("ЖКУ-Москва");
        waiting(driver, xpath("//div[@data-qa-file=\"Text\"][contains(text(), 'Ничего не найдено')]"));
        String notfindspb = driver.findElement(xpath("//div[@data-qa-file=\"Text\"][contains(text(), 'Ничего не найдено')]")).getText();
        assertTrue(notfindspb.equals("Ничего не найдено"));

    }

}