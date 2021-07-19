package org.example.place;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ReviewsTest {

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
        driver.get("https://reviews.yandex.ru/ugcpub/cabinet?main_tab=professions");
    }

    @Test
    public void pageTest() {
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
