import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Nikolay on 13.07.2016.
 */
public class loginTest {
    @Test
    public void openLinkedin() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        driver.findElement(By.xpath("//input[@")).click();
        driver.findElement(By.linkText("Menu")).click();
        driver.findElement(By.linkText("Desserts")).click();
        driver.close();
        WebElement emailfield = driver.findElement(By.linkText("Menu"));
        emailfield.click();
    }
}
