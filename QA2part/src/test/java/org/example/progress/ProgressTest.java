package org.example.progress;

import org.example.ConfProperties;
import org.example.place.PlacePage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProgressTest {
    public static ProgressPage progressPage;

    public static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setup() {
        // определние пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
        // создание экземпляра драйвера
        driver = new ChromeDriver();
        progressPage = new ProgressPage(driver);
        // окно разворачивается на полный экран
        driver.manage().window().maximize();
        // задержка на выполнение теста 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://reviews.yandex.ru/ugcpub/cabinet?main_tab=professions");
    }

    @Test
    public void pageTest() {
        // Нажимаем на кнопку "Достижения"
        progressPage.achievBtn();
        //получаем ссылку страницы для сравнивания
        String url = driver.getCurrentUrl();
        Assert.assertEquals(ConfProperties.getProperty("progresspage"), url);
    }
}
