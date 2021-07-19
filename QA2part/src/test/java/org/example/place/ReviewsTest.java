package org.example.place;

import org.example.ConfProperties;
import org.example.login.LoginPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ReviewsTest {

    public static LoginPage loginPage;
    public static PlacePage placePage;

    public static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setup() {
        // определние пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
        // создание экземпляра драйвера
        driver = new ChromeDriver();
        placePage = new PlacePage(driver);
        // окно разворачивается на полный экран
        driver.manage().window().maximize();
        // задержка на выполнение теста 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void pageTest() {
        // вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        // нажимаем кнопку входа
        loginPage.clickLoginBtn();
        // вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        // нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //нажимаем на звездочки для получения оценки
        placePage.rate();
        // нажимаем кнопку отправить
        placePage.sendRate();
        // нажимаем отзывы и оценки
        placePage.rateRev();
        // берем имена карточек и сверяем их
        String card1 = placePage.getCardName();
        String card2 = placePage.getCardNameAfter();
        Assert.assertEquals(card1, card2);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
