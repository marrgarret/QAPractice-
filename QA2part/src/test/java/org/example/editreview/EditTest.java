package org.example.editreview;

import org.example.ConfProperties;
import org.example.findplace.FindPlacePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EditTest {

    public static EditPage editPage;

    public static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setup() {
        // определние пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
        // создание экземпляра драйвера
        driver = new ChromeDriver();
        editPage = new EditPage(driver);
        // окно разворачивается на полный экран
        driver.manage().window().maximize();
        // задержка на выполнение теста 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://reviews.yandex.ru/ugcpub/cabinet?main_tab=reviews&reviews_tab=film");
    }

    public void FindTest() {
        // нажать на троеточия для выпадения списка
        editPage.dotsBtn();
        // нажать на изменить отзыв в выпадающем окне
        editPage.editBtn();
        // поменять отзыв
        editPage.inputReview(ConfProperties.getProperty("review"));
        // нажать сохранить
        editPage.save();
        // проверить совпадения ожидаемого и результата
        String review = editPage.getReview();
        Assert.assertEquals(ConfProperties.getProperty("review"), review);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
