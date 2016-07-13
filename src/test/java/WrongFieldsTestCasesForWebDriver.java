import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Nikolay on 13.07.2016.
 */
public class WrongFieldsTestCasesForWebDriver {
    /**
     * Test completes successfully if correct message is displayed when
     * password is to short
     */
    @Test
    public void testPass(){
        ActionsByWebDriver demo = new ActionsByWebDriver();
        String s = demo.openLinkedin("John", "Doe", "jsdfwe23424@gmail.com", "12345");
        Assert.assertEquals("Пароль должен быть не менее 6 символов.", s);
    }

    /**
     * Test completes successfully if correct message is displayed when
     * name is empty
     */
    @Test
    public void testFname(){
        ActionsByWebDriver demo = new ActionsByWebDriver();
        String s = demo.openLinkedin("", "Doe", "jsdfwe23424@gmail.com", "12345");
        Assert.assertEquals("Укажите имя", s);
    }

    /**
     * Test completes successfully if correct message is displayed when
     * lastnamename is empty
     */
    @Test
    public void testLname(){
        ActionsByWebDriver demo = new ActionsByWebDriver();
        String s = demo.openLinkedin("John", "", "jsdfwe23424@gmail.com", "12345");
        Assert.assertEquals("Укажите фамилию", s);
    }

    /**
     * Test completes successfully if correct message is displayed when
     * email is incorrect
     */
    @Test
    public void testWrongEmail(){
        ActionsByWebDriver demo = new ActionsByWebDriver();
        String s = demo.openLinkedin("John", "Doe", "jsdfwe23424gmail.com", "12345");
        Assert.assertEquals("Укажите действительный адрес электронной почты", s);
    }

    /**
     * Test completes successfully if correct message is displayed when
     * email is empty
     */
    @Test
    public void testEmptyEmail(){
        ActionsByWebDriver demo = new ActionsByWebDriver();
        String s = demo.openLinkedin("John", "Doe", "", "12345");
        Assert.assertEquals("Укажите свой адрес электронной почты", s);
    }
}