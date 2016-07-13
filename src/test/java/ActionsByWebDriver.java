import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Nikolay on 13.07.2016.
 */

public class ActionsByWebDriver {
    private final String URL = "http://www.linkedin.com/";

    /**
     * This method takes next parameters to access linkedin home page and fill in registration form
     * and sign up as a new user
     *
     * @param fname - first name
     * @param lname - last name
     * @param email - user email
     * @param pass  - user password
     *              Then, if some of parameters was wrong, it returns error message
     */

    public String openLinkedin(String fname, String lname, String email, String pass) {
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);
        WebElement fNameField = driver.findElement(By.xpath(".//*[@id='first-name']"));
        WebElement lNameField = driver.findElement(By.xpath(".//*[@id='last-name']"));
        WebElement emailField = driver.findElement(By.xpath(".//*[@id='join-email']"));
        WebElement passwordField = driver.findElement(By.xpath(".//*[@id='join-password']"));
        WebElement signUpButton = driver.findElement(By.xpath(".//*[@id='pagekey-uno-reg-guest" +
                "-home']/div[2]/div[2]/div/div[2]" +
                "/div/div/div/form/fieldset/button"));


        fNameField.sendKeys(fname);
        lNameField.sendKeys(lname);
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        signUpButton.click();

        WebElement errorMessage = driver.findElement(By.xpath(".//*[@id='pagekey-uno-reg-guest-home']/" +
                "div[2]/div[2]/div/div[2]/div/div/div/" +
                "div[1]/div/p/strong"));

        String check = errorMessage.getText();
        driver.close();
        return check;
    }
}