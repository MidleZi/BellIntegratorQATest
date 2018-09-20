package ru.tinkoff;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;



public class TinkoffTest extends WebDriverSettings {


    @Test
    public void testTinkoff() {

        //Шаг №1
        driver.get("https://www.tinkoff.ru"); //открываем сайт
        waiting();

        // Шаг №2
        driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[7]/div/footer/div[2]/div/div/ul/li[1]/ul/li[6]/span/span/a")).click(); //жмем на кнопку "Платежи"
        waiting();

        // Шаг №3
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/a/span/div/div[2]/div/div/div")).click(); //жмем на кнопку "ЖКХ"
        waiting();

        //Шаг №4
       String region = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[2]/div/div/div/span/span/span")).getText();
        assertTrue(region.equals("Москве"));

        //Шаг №5
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/section/ul/li[1]/span[2]/a/span/div")).click(); //жмем на кнопку "ЖКУ-Москва"
        waiting();
        String zhkumoskvapage = driver.getCurrentUrl();

        //Шаг №6
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div/div/div/div[3]/div/ul/li[2]/div/a/span")).click(); //жмем на кнопку "Оплатить ЖКУ в Москве"
        waiting();

        //Шаг №7
        driver.findElement(By.xpath("//button")).click(); //жмем на кнопку "Оплатить"
        String field1 = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[1]/div/div[2]")).getText(); //проверяем сообщение об ошибке 1-ого поля
        assertTrue(field1.equals("Поле обязательное"));

        String field2 = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[2]/div/div[2]")).getText(); //проверяем сообщение об ошибке 2-ого поля
        assertTrue(field2.equals("Поле обязательное"));

        String field3 = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div/div/div/div[4]/div[1]/form/div[4]/div/div/div/div/div/div/div/div[2]")).getText(); //проверяем сообщение об ошибке 3-его поля
        assertTrue(field3.equals("Поле обязательное"));

        // Шаг №8
        driver.findElement(By.xpath("//a[contains(text(),'Платежи')]")).click(); //жмем на кнопку "Платежи"
        waiting();

        //Шаг №9
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[4]/div/div[2]/div[2]/div/form/div[3]/div/div/div/div/label/div/input")).sendKeys("ЖКУ-Москва");
        waiting();

        //Шаг №10
        WebElement find = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[4]/div/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div[1]/div/div/div[1]/div"));
        String findtext = find.getText();
        //Подозреваю, что тут не соответствует заданию, т.к. я ссылаюсь на конкретный элемент, а не на первый элемент страницы, но могу и ошибаться

        //Шаг №11
        assertTrue(findtext.equals("ЖКУ-Москва\nКоммунальные платежи"));
        find.click();
        waiting();

        assertTrue(zhkumoskvapage.equals(driver.getCurrentUrl()));

        // Шаг №12
        driver.findElement(By.xpath("//a[contains(text(),'Платежи')]")).click(); //жмем на кнопку "Платежи"
        waiting();

        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div/a/span/div/div[2]/div/div/div")).click(); //жмем на кнопку "ЖКХ"
        waiting();

        //Шаг №13
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[2]/div/div/div/span/span/span")).click();
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[4]/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/span/a/span")).click();
        waiting();

        //Шаг 14
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[3]/div/div[1]/label/div/input")).sendKeys("ЖКУ-Москва");
        waiting();
        String notfindspb = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[3]/div/div[2]/div/div/div/div/div[1]/div/div[1]/div")).getText();
        assertTrue(notfindspb.equals("Ничего не найдено"));
    }

}