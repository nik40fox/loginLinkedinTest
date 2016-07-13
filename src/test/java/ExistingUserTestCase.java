import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nikolay on 13.07.2016.
 */


public class ExistingUserTestCase {
    /**
     * This method opens linkedin, fills up registration form and check is
     * correct message displayed when this email is already exist
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
        emailField.sendKeys("mc_valkir@mail.ru");
        passwordField.sendKeys("tiramisu");
        signUpButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement errorMessage = driver.findElement(By.cssSelector(".hopscotch-title"));

        String check = errorMessage.getText();
        Assert.assertEquals("Пытаетесь выполнить вход?", check);
        driver.close();
    }
}
