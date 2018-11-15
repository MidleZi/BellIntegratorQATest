package ru.tests.youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadVideoPage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//button[@aria-label=\"Выберите файлы, которые хотите загрузить\"]")
    private WebElement loadInput;

    @FindBy(xpath = "//div[@id=\"start-upload-button-single\"]")
    private WebElement loadButton;

    @FindBy(xpath= "//div[@class=\"upload-status-text\"]")
    private WebElement statusText;

    @FindBy(xpath="//div[@style=\"overflow: hidden;\"]//textarea[@class=\"yt-uix-form-input-textarea video-settings-description\"]")
    private WebElement descriptionField;

    @FindBy(xpath="//div[@style=\"overflow: hidden;\"]//input[@class=\"video-settings-add-tag\"]")
    private WebElement tagField;

    @FindBy(xpath="//span[text()=\"Опубликовать\"]")
    private WebElement publichButton;

    public WebElement getDescriptionField() {
        return descriptionField;
    }

    public WebElement getStatusText() {
        return statusText;
    }

    public WebElement getLoadButton() {
        return loadButton;
    }

    public void loadButtonClick() {
        loadInput.click();
    }

    public WebElement getLoadInput() {
        return loadInput;
    }

    public WebElement getTagField() {
        return tagField;
    }

    public WebElement getPublichButton() {
        return publichButton;
    }
}
