package ru.tinkoff;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void close() {
        driver.quit();
    }

   public void waiting(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waiting(WebDriver driver, By by){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
