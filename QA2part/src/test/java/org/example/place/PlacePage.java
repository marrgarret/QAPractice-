package org.example.place;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlacePage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public PlacePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // локатор отзыва места
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/div[1]/div/div[6]/div/div/div/div/div[1]/div")
    private WebElement cardReview;

    //звездочки
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/div[1]/div/div[6]/div/div/div/div/div[1]/div/div[3]")
    private WebElement rate;

    // локатор кнопки отправить
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/div[1]/div/div[6]/div/div/div/div/div[1]/div/div[3]/div/button")
    private WebElement sendBtn;

    // локатор кнопки "Оценки и отзывы"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[1]/div/div[1]/div/div[2]/div[2]")
    private WebElement rateRevBtn;

    // локатор карточки
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/section/div[2]/div/div/div[1]/div[1]")
    private WebElement cardRevAfter;

    /**
     * метод для выставления оценки
     */
    public void rate() {
        rate.click();
    }

    /**
     * метод для нажатия кнопки отправить
     */
    public void sendRate() {
        sendBtn.click();
    }

    /**
     * метод для нажатия кнопки "Оценки и отзывы"
     */
    public void rateRev() {
        rateRevBtn.click();
    }

    // метод получения карточки на главной странице
    public String getCardName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/div[1]/div/div[6]/div/div/div/div/div[1]/div")));
        return cardReview.getText();
    }

    // метод получения карточки на странице оценки и отзывы
    public String getCardNameAfter() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/section/div[2]/div/div/div[1]/div[1]")));
        return cardRevAfter.getText();
    }
}
