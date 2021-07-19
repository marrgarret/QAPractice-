package org.example.findplace;

import org.example.ConfProperties;
import org.example.login.LoginPage;
import org.example.movie.MoviePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindTest {

    public static LoginPage loginPage;
    public static FindPlacePage findPlacePage;

    public static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setup() {
        // определние пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
        // создание экземпляра драйвера
        driver = new ChromeDriver();
        findPlacePage = new FindPlacePage(driver);
        // окно разворачивается на полный экран
        driver.manage().window().maximize();
        // задержка на выполнение теста 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void FindTest() {
        // вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        // нажимаем кнопку входа
        loginPage.clickLoginBtn();
        // вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        // нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //нажать на кнопку найти места
        findPlacePage.findPlace();
        //набрать место в нужном окошке
        findPlacePage.inputPlace(ConfProperties.getProperty("place"));

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
