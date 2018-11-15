package ru.tests.youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubeMainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id=\"masthead-container\"]//yt-formatted-string[text()='Войти']")
    private WebElement loginButton;
    @FindBy(xpath = "//button[@aria-label=\"Создать видео или запись\"]")
    private WebElement createOrAddVideoButton;
    @FindBy(xpath = "//yt-formatted-string[text()='Добавить видео']")
    private WebElement addVideoButton;
    @FindBy(xpath = "//input[@id=\"search\"]")
    private WebElement searchField;
    @FindBy(xpath = "//button[@id=\"search-icon-legacy\"]")
    private WebElement searchButton;

    public void open(){
        driver.get("https://youtube.com");
    }

    public void loginButtonClick(){
        loginButton.click();
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getCreateOrAddVideoButton() {
        return createOrAddVideoButton;
    }


    public WebElement getAddVideoButton() {
        return addVideoButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

}
