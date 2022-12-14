package Locators;
import org.openqa.selenium.*;

public class RecoverPasswordPage {
    private WebDriver driver;
    private By loginButton = By.className("Auth_link__1fOlj");
    public RecoverPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void scrollToLoginButton(){
        WebElement element = driver.findElement(loginButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
