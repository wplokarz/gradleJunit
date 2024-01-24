import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Junit
public class Test1 {
    @Test
    public void loginTest() {
        WebDriver driver = new ChromeDriver();
        String url = "https://practicetestautomation.com/practice-test-login/";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        username.sendKeys("student");
        password.sendKeys("Password123");
        submitButton.click();
        WebElement successTextOnPage = driver.findElement(By.cssSelector("h1.post-title"));
        String actualResult = successTextOnPage.getText();
        String expectedResult = "Logged In Successfully";
        Assertions.assertEquals(expectedResult, actualResult);
        driver.quit();
    }
}
