package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShoppingCartPage {
    private static final By QUANTITY_TEXT_BOX = By.xpath("//input[@name='cart_quantity[]']");
    private static final By UPDATE_QUANTITY_BUTTON = By.id("tdb4");
    private static final By PRODUCT_PRICE = By.xpath("//p[@align='right']//strong");
    private static final By CHECKOUT_BUTTON = By.id("tdb5");
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void updateQuantity(int quantity) {
        String initialPrice = driver.findElement(PRODUCT_PRICE).getText();
        WebElement quantityTextBoxElement = driver.findElement(QUANTITY_TEXT_BOX);
        quantityTextBoxElement.clear();
        quantityTextBoxElement.sendKeys(String.valueOf(quantity));
        WebElement updateQuantityButtonElement = driver.findElement(UPDATE_QUANTITY_BUTTON);
        updateQuantityButtonElement.click();
        String updatedPrice = driver.findElement(PRODUCT_PRICE).getText();
        assertNotEquals(initialPrice, updatedPrice);
    }

    public void continueToCheckout() {
        WebElement checkoutButtonElement = driver.findElement(CHECKOUT_BUTTON);
        checkoutButtonElement.click();
    }
}
