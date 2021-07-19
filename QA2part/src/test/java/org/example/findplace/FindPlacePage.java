package org.example.findplace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindPlacePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public FindPlacePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // кнопка "Найти место"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/section/div[2]/div/div/div[1]/div/button")
    private WebElement findBtn;

    // локатор для ввода названия
    @FindBy(xpath = "//*[@id=\"root\"]/div/section/div[2]/div/div[1]/span")
    private WebElement searchBlock;

    /**
     * метод нажатия кнопки
     */
    public void findPlace() {
        findBtn.click();
    }

    /**
     * метод для ввода названия
     */
    public void inputPlace(String login) {
        searchBlock.sendKeys(login);
    }
}
