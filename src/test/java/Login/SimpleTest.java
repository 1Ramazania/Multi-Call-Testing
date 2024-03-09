package Login;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SimpleTest {
    WebDriver driver;

    @DataProvider(name = "searchQueries")
    public Object[][] searchData() {
        return new Object[][]{
                {"hepsiburada"},
                {"trendyol"},
                {"amazon"},
                // İstediğiniz kadar sorguyu buraya ekleyebilirsiniz
        };
    }

    @Test(dataProvider = "searchQueries")
    public void googleSearch(String query) throws InterruptedException {
        // WebDriver'ı başlat
        WebDriver driver = new ChromeDriver();

        try {
            // Google ana sayfasını aç
            driver.get("https://www.google.com");

            // Arama kutusunu bul ve sorguyu gönder
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(query);
            searchBox.sendKeys(Keys.ENTER);

            // Arama sonuçlarını kontrol etmek için bekleyin (opsiyonel)
            Thread.sleep(3000); // Beklenen süre

            // Assert işlemi ile sonuçları doğrula
            Assert.assertTrue(driver.getTitle().contains(query));
        } finally {
            // WebDriver'ı kapat
            driver.quit();
        }
    }
}
