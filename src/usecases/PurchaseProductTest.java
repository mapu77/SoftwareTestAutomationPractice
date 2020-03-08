package usecases;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import processes.PurchaseProcess;

import java.util.ArrayList;


public class PurchaseProductTest {
    private static WebDriver driver;
    private PurchaseProcess purchaseProcess;

    public static void createAndStartService() {
        ArrayList<String> optionsList = new ArrayList<>();
        ChromeOptions chromeOptions = new ChromeOptions();
        optionsList.add("--start-maximized");
        optionsList.add("--incognito");
        optionsList.add("disable-notifications");
        chromeOptions.addArguments(optionsList);
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver(chromeOptions);
    }

    public static void quitDriver() {
        driver.quit();
    }

    @BeforeAll
    static void setUpBeforeClass() {
        createAndStartService();
    }

    @BeforeEach
    void setUp() {
        purchaseProcess = new PurchaseProcess(driver);
    }

    @AfterEach
    public void tearDown() {
        logout();
    }

    private void logout() {
        WebElement logoutButtonElement = driver.findElement(By.id("tdb4"));
        logoutButtonElement.click();
    }

    @AfterAll
    static void tearDownBeforeClass() {
        quitDriver();
    }

    @Test
    void shouldPurchaseTwoSamsungGalaxyTabsAndPayCashOnDelivery() {
        purchaseProcess.buy("Samsung Galaxy Tab", 2, "Cash on Delivery");
    }

    @Test
    void shouldPurchaseThreeBelovedAndPayCashOnDelivery() {
        purchaseProcess.buy("Beloved", 3, "Cash on Delivery");
    }
}



