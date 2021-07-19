package org.example.progress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProgressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // локатор кнопки достижения
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[1]/div/div[1]/div/div[2]/div[3]")
    private WebElement achievements;

    /**
     * метод для нажатия кнопки
     */
    public void achievBtn() {
        achievements.click();
    }
}
