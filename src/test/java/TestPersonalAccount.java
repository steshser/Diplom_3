import Locators.LoginPage;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import Locators.PersonalAccountPage;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import Locators.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Step;

public class TestPersonalAccount {
    private WebDriver driver;
    private final String email = "steshov.sergey@yandex.ru";
    private final String password = "sergey1234";

    @Test
    @Step("Check click on the Personal Account button")
    public void testClickPersonalAccountButtonChrome(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        assertEquals("https://stellarburgers.nomoreparties.site/account", driver.getCurrentUrl());
    }

    @Test
    @Step("Check click on the Constructor button")
    public void testClickConstructorButtonChrome(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickConstructorButton();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @Step("Check click on the Stellar burger logo")
    public void testClickStellarBurgerLogoChrome(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickStellarBurgersLogo();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @Step("Check click on the Personal Account button")
    public void testClickPersonalAccountButtonYandex(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        assertEquals("https://stellarburgers.nomoreparties.site/account", driver.getCurrentUrl());
    }

    @Test
    @Step("Check click on the Constructor button")
    public void testClickConstructorButtonYandex(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickConstructorButton();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @Step("Check click on the Stellar burger logo")
    public void testClickStellarBurgerLogoYandex(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickStellarBurgersLogo();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @Step("Check click on the Logout button")
    public void testClickLogoutButtonChrome() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickLogoutButton();
        Thread.sleep(1000);
        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

    @Test
    @Step("Check click on the Logout button")
    public void testClickLogoutButtonYandex() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickLogoutButton();
        Thread.sleep(1000);
        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

    @After
    @Step("Quit browser")
    public void logOut(){
        driver.quit();
    }
}
