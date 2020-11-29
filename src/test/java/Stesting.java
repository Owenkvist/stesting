import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stesting {

    private WebDriver driver;
    private MainPage mainPage;
    private List<String> siteList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @Test
    public void google() {
        driver.get("https://www.google.ru/");
        mainPage.enterText("купить кофемашину bork c804");
        mainPage.clickOnSearchButton();
        List<WebElement> elements = driver.findElements(By.xpath("//cite[@class='iUh30 Zu0yb qLRx3b tjvcx']"));
        for (WebElement text : elements) {
            String s = text.getAttribute("textContent");
            siteList.add(s);
        }
        if (siteList.contains("www.mvideo.ru › ... › Кофейные станции › Bork")) {
            System.out.println("www.mvideo.ru Есть в списке!");
        } else System.out.println("Упссс...www.mvideo.ru Нет в списке");
        String count = mainPage.getCount();
        String substring = count.substring(22, 27);
        int value = Integer.parseInt(substring.replaceAll("[^0-9]", ""));
        boolean check = value > 10;
        assertEquals(true, check);
    }

    @Test
    public void signInYandex() {
        driver.get("https://passport.yandex.ru/auth?origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fyandex.ru");
        mainPage.typeUsername("TestKvist");
        mainPage.clickOnInButton();
        mainPage.typeUserpass("123456Aa");
        mainPage.clickOnInButton();
        String sigInHeader = mainPage.getSigInHeader();
        assertEquals("TestKvist", sigInHeader);
    }

    @Test
    public void registrationInYandex() {
        driver.get("https://passport.yandex.ru/auth?origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fyandex.ru");
        mainPage.clickOnRegisterButton();
        mainPage.registerWithPhoneNumber("Test", "Kvist", "TestKvist", "123456Aa", "123456Aa", "9000000000");
    }

    @AfterEach
    public void tearDownEach() {
        driver.quit();
    }
}
