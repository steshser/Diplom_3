import Locators.RegistrationPage;
import Locators.LoginPage;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import Locators.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;

public class TestPasswordLength {
    private WebDriver driver;
    private final String shortPassword = "123";

    @Test
    @Step("Error of short password is visible at Chrome")
    public void testVisibilityErrorOfShortPasswordChrome(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickEnterToAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegistrationButton();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        assertNotNull(objRegistrationPage.waitPasswordErrorVisible(shortPassword));
    }

    @Test
    @Step("Error of short password is visible at Yandex")
    public void testVisibilityErrorOfShortPasswordYandex(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickEnterToAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegistrationButton();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        assertNotNull(objRegistrationPage.waitPasswordErrorVisible(shortPassword));
    }

    @After
    @Step("Quit browser")
    public void logOut(){
        driver.quit();
    }
}
