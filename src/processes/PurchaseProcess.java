package processes;


import org.openqa.selenium.WebDriver;
import screens.*;

public class PurchaseProcess {
    private Homepage homepage;
    private ProductDetailPage productDetailPage;
    private ShoppingCartPage shoppingCartPage;
    private LoginPage loginPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;

    public PurchaseProcess(WebDriver driver) {
        this.homepage = new Homepage(driver);
        this.productDetailPage = new ProductDetailPage(driver);
        this.shoppingCartPage = new ShoppingCartPage(driver);
        this.loginPage = new LoginPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.confirmationPage = new ConfirmationPage(driver);
    }

    public void buy(String productName, int quantity, String paymentMethod) {
        homepage.visit();
        homepage.selectProduct(productName);
        productDetailPage.addToCart();
        shoppingCartPage.updateQuantity(quantity);
        shoppingCartPage.continueToCheckout();
        loginPage.login("test_edu@test.com", "aaaaa");
        checkoutPage.proceedWithDefaultShippingDetails();
        checkoutPage.selectPaymentMethod(paymentMethod);
        checkoutPage.confirmPurchase();
        confirmationPage.finishProcess();
    }
}