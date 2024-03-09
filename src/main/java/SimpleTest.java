import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest {
    public static void main(String[] args) {
        // WebDriver'ı başlat
        WebDriver driver = new ChromeDriver();

        // Google'a git
        driver.get("https://www.google.com");

        // WebDriver'ı kapat
        driver.quit();
    }
}
