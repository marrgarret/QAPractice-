package org.example.progress;

import org.example.ConfProperties;
import org.example.login.LoginPage;
import org.example.place.PlacePage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProgressTest {
    public static LoginPage loginPage;
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
        driver.get(ConfProperties.getProperty("loginpage"));;
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

        // Нажимаем на кнопку "Достижения"
        progressPage.achievBtn();
        //получаем ссылку страницы для сравнивания
        String url = driver.getCurrentUrl();
        Assert.assertEquals(ConfProperties.getProperty("progresspage"), url);
    }
}
