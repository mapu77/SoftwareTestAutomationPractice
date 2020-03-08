package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.AssertionHelpers.assertUrlContains;

public class Homepage {
    private static final String PRODUCT_INFO_PAGE_NAME = "product_info";
    private static final String MAIN_PAGE = "index";
    private final WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit() {
        driver.get("https://demo.oscommerce.com/index.php");
        assertUrlContains(driver, MAIN_PAGE);
    }

    public void selectProduct(String productName) {
        WebElement productElement = driver.findElement(By.linkText(productName));
        productElement.click();
        assertUrlContains(driver, PRODUCT_INFO_PAGE_NAME);
    }

}
