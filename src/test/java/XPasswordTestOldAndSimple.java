import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Nikolay on 13.07.2016.
 */


public class XPasswordTestOldAndSimple {
    /**
     * This method opens linkedin, fills up registration form and check is
     * correct message displayed when password isn't long enough
     */
    @Test
    public void openLinkedin() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        WebElement fNameField = driver.findElement(By.xpath(".//*[@id='first-name']"));
        WebElement lNameField = driver.findElement(By.xpath(".//*[@id='last-name']"));
        WebElement emailField = driver.findElement(By.xpath(".//*[@id='join-email']"));
        WebElement passwordField = driver.findElement(By.xpath(".//*[@id='join-password']"));
        WebElement signUpButton = driver.findElement(By.xpath(".//*[@id='pagekey-uno-reg-guest" +
                                                                "-home']/div[2]/div[2]/div/div[2]" +
                                                                "/div/div/div/form/fieldset/button"));
        fNameField.sendKeys("John");
        lNameField.sendKeys("Doe");
        emailField.sendKeys("johndoe9876567897766@gmail.com");
        passwordField.sendKeys("12345");
        signUpButton.click();

        WebElement errorMessage = driver.findElement(By.xpath(".//*[@id='pagekey-uno-reg-guest-home']/" +
                                                                "div[2]/div[2]/div/div[2]/div/div/div/" +
                                                                "div[1]/div/p/strong"));

        String check = errorMessage.getText();
        Assert.assertEquals("Пароль должен быть не менее 6 символов.", check);
        driver.close();
    }
}
