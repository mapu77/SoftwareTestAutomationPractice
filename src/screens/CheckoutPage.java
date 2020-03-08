package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.AssertionHelpers.assertUrlContains;

public class CheckoutPage {
    private static final By CONTINUE_BUTTON = By.id("tdb6");
    private static final String CHECKOUT_PAYMENT_PAGE = "checkout_payment";
    private static final String CHECKOUT_SHIPPING_PAGE = "checkout_shipping";
    private static final String CHECKOUT_CONFIRMATION_PAGE = "checkout_confirmation";
    private static final By PAY_NOW_BUTTON = By.id("tdb5");
    private static final String CHECKOUT_SUCCESS_PAGE = "checkout_success";
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedWithDefaultShippingDetails() {
        assertUrlContains(driver, CHECKOUT_SHIPPING_PAGE);
        WebElement continueButtonElement = driver.findElement(CONTINUE_BUTTON);
        continueButtonElement.click();
        assertUrlContains(driver, CHECKOUT_PAYMENT_PAGE);
    }

    public void selectPaymentMethod(String paymentMethod) {
        By paymentMethodXPath = By.xpath("//strong[text()='" + paymentMethod + "']/parent::td/following-sibling::td/input");
        WebElement paymentRadioElement = driver.findElement(paymentMethodXPath);
        paymentRadioElement.click();
        WebElement continueButtonElement = driver.findElement(CONTINUE_BUTTON);
        continueButtonElement.click();
        assertUrlContains(driver, CHECKOUT_CONFIRMATION_PAGE);
    }

    public void confirmPurchase() {
        WebElement continueButtonElement = driver.findElement(PAY_NOW_BUTTON);
        continueButtonElement.click();
        assertUrlContains(driver, CHECKOUT_SUCCESS_PAGE);
    }
}
