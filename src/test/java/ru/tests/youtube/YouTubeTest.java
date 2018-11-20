package ru.tests.youtube;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.tests.WebDriverSettings;

import java.util.List;

public class YouTubeTest extends WebDriverSettings {

    private String email = "***";
    private String password = "***";
    private Alert alert;

    @Test
    public void youTubeTest(){
        YouTubeMainPage mainPage = PageFactory.initElements(driver, YouTubeMainPage.class);
        GoogleLoginPage loginPage = PageFactory.initElements(driver, GoogleLoginPage.class);
        LoadVideoPage loadVideoPage = PageFactory.initElements(driver, LoadVideoPage.class);

        //Шаг 1
        //mainPage.open();
        driver.get("https://youtube.com");

        //Шаг 2
        mainPage.getLoginButton().click();
        waiting(driver, By.xpath("//span[text()='Далее']"));
        loginPage.getEmailField().sendKeys(email);
        loginPage.nextButtonClick();
        waiting(driver, By.xpath("//input[@type=\"password\"]"));
        loginPage.getPassField().sendKeys(password);
        loginPage.nextButtonClick();
        waiting(driver, By.xpath("//button[@aria-label=\"Создать видео или запись\"]"));

        //Шаг 3 не могу нажать кнопку, пока пропущу
        mainPage.getCreateOrAddVideoButton().click();
        waiting(driver, By.xpath("//yt-formatted-string[text()='Добавить видео']"));
        mainPage.getAddVideoButton().click();
        waiting(driver, By.xpath("//button[@aria-label=\"Выберите файлы, которые хотите загрузить\"]"));
        waiting(driver, By.xpath("//div[@id=\"start-upload-button-single\"]"));

        //Шаг 4
        loadVideoPage.addFile.sendKeys("E:\\Java\\tests\\111.mp4");


        //Шаг 5
        waiting(driver, By.xpath("//div[@class=\"upload-status-text\"]"));
        while(!loadVideoPage.getStatusText().getText().equals("Загрузка завершена!")){
            System.out.println("Жду statusText");
        }

        //Шаг 6
        loadVideoPage.getDescriptionField().sendKeys("MidleZiLimpopo");
        loadVideoPage.getTagField().sendKeys("MidleZiLimpopo");

        //Шаг 7
        loadVideoPage.getPublichButton().click();
        waiting();




        //Шаг 8
        driver.get("https://youtube.com");
        driver.switchTo().alert().accept();
        waiting(driver, By.xpath("//button[@id=\"search-icon-legacy\"]"));

        //Шаг 9
        mainPage.getSearchField().sendKeys("midlezilimpopo");
        mainPage.getSearchButton().click();
        waiting(driver, By.xpath("//span[@class=\"bold style-scope yt-formatted-string\"]"));

        //Шаг 10
        List<WebElement> elementList = driver.findElements(By.xpath("//span[@class=\"bold style-scope yt-formatted-string\"]"));
        Assert.assertTrue(elementList.get(0).getText().equals("MidleZiLimpopo"));


    }
}
