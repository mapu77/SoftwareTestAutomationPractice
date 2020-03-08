package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfirmationPage {
    private static final String SUCCESS_MESSAGE = "Your Order Has Been Processed!";
    private static final By HEADER_MESSAGE = By.xpath("//div[@id='bodyContent']/h1");
    private static final By CONTINUE_BUTTON = By.id("tdb5");
    private WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void finishProcess() {
        WebElement titleElement = driver.findElement(HEADER_MESSAGE);
        assertEquals(SUCCESS_MESSAGE, titleElement.getText());
        WebElement continueButtonElement = driver.findElement(CONTINUE_BUTTON);
        continueButtonElement.click();
    }
}
