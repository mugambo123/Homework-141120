import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Barclays extends BaseTest {

    @Before
    public void setUp() {
        openBrowser("https://www.barclays.co.uk/");
    }

    @Test
    public void login() {

        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
        loginLink.click();

        String expectedMessage = "Quick, safe and convenient - Online Banking made easy";
        WebElement message = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/ng-include[1]/div[1]/div[2]/h2[1]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        WebElement surname = driver.findElement(By.xpath("//input[@id='surname0']"));
        surname.sendKeys("smith");

        WebElement cardNumber = driver.findElement(By.xpath("//label[contains(text(),'Card number')]"));
        cardNumber.click();


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
