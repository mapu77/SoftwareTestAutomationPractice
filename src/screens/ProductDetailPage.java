package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.AssertionHelpers.assertUrlContains;

public class ProductDetailPage {
    private static final By ADD_TO_CART_BUTTON = By.id("tdb4");
    private static final String SHOPPING_CART_PAGE = "shopping_cart";
    private final WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        WebElement addToCartButtonElement = driver.findElement(ADD_TO_CART_BUTTON);
        addToCartButtonElement.click();
        assertUrlContains(driver, SHOPPING_CART_PAGE);
    }
}
