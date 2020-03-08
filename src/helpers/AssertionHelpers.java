package helpers;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionHelpers {
    private AssertionHelpers() {}

    public static void assertUrlContains(WebDriver driver, String expectedPageName) {
        assertTrue(driver.getCurrentUrl().contains(expectedPageName), String.format("Can't access %s page", expectedPageName));
    }
}