import Locators.RegistrationPage;
import Locators.LoginPage;
import Locators.PersonalAccountPage;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import Locators.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.concurrent.TimeUnit;

public class TestRegistration {
    private WebDriver driver;
    private String name;
    private String email;
    private final String password = "autotest12345";


    @Before
    @Step("Create random user data")
    public void createRegistrationData(){
        name = RandomStringUtils.randomAlphabetic(8);
        email = name + "@gmail.com";
    }


    @Test
    @Step("Registration in Chrome")
    public void testRegistrationChrome() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickEnterToAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegistrationButton();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.registration(name, email, password);
        Thread.sleep(1000);
        objLoginPage.login(email, password);
        objMainPage.clickPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        String accountName = objPersonalAccountPage.getNameFieldValue();
        String accountEmail = objPersonalAccountPage.getEmailFieldValue();
        assertEquals(name, accountName);
        assertEquals(email.toLowerCase(), accountEmail);
        objPersonalAccountPage.clickLogoutButton();
    }

    @Test
    @Step("Registration in Yandex")
    public void testRegistrationYandex() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickEnterToAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegistrationButton();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.registration(name, email, password);
        Thread.sleep(1000);
        objLoginPage.login(email, password);
        objMainPage.clickPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        String accountName = objPersonalAccountPage.getNameFieldValue();
        String accountEmail = objPersonalAccountPage.getEmailFieldValue();
        assertEquals(name, accountName);
        assertEquals(email.toLowerCase(), accountEmail);
        objPersonalAccountPage.clickLogoutButton();
    }

    @After
    @Step("Quit browser")
    public void logOut(){
        driver.quit();
    }
}
