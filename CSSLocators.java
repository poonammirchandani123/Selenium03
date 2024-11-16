import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CSSLocators {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();

            // Explicit wait to ensure the search box is present before interacting with it
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#small-searchterms")));

            // Enter text into the search box
            searchBox.sendKeys("T-shirts");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the operation
            driver.quit();
        }
    }
}

