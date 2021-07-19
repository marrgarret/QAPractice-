package org.example.editreview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public EditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // кнопка троеточия
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/section/div[2]/div/div/div[1]/div/div[3]/div/div/button/div")
    private WebElement dotsBtn;

    // кнопка изменить отзыв
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/section/div[2]/div/div/div[1]/div/div[3]/div/div/div/div/div[1]")
    private WebElement editRev;

    // окно для написания отзыва
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/section/div[2]/div/div/div[1]/div/div[2]/div/div[3]/span/span")
    private WebElement review;

    // кнопка сохранить отзыв
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/section/div[2]/div/div/div[1]/div/div[2]/div/button")
    private WebElement edited;

    // окошко с новым отзывом (чтобы получить из него имя для сравнения)
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/section/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div")
    private WebElement newRevName;

    /**
     * метод нажатия кнопки троеточия
     */
    public void dotsBtn() {
        dotsBtn.click();
    }

    /**
     * метод нажатия кнопки изменить отзыв
     */
    public void editBtn() {
        editRev.click();
    }

    /**
     * метод для написания отзыва
     */
    public void inputReview(String rev) {
        review.sendKeys(rev);
    }

    /**
     * метод нажатия кнопки сохранить отзыв
     */
    public void save() {
        edited.click();
    }

    // метод для получения нового отзыва
    public String getReview() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/section/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div")));
        return newRevName.getText();
    }

}
