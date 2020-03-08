package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static final By EMAIL_TEXT_BOX = By.xpath("//input[@name='email_address']");
    private static final By PASSWORD_TEXT_BOX = By.xpath("//input[@name='password']");
    private static final By SIGN_IN_BUTTON = By.id("tdb1");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        WebElement emailTextElement = driver.findElement(EMAIL_TEXT_BOX);
        emailTextElement.sendKeys(email);
        WebElement passwordTextElement = driver.findElement(PASSWORD_TEXT_BOX);
        passwordTextElement.sendKeys(password);
        WebElement signInButtonElement = driver.findElement(SIGN_IN_BUTTON);
        signInButtonElement.click();
    }
}
