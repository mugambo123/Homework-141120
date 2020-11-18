package NopcommerceJUnit;
////Problem(Bug) : Login details like password and email is not working properly despite providing correct details.
/*Automate to register on https://demo.nopcommerce.com by initialising variable webBrowser by entering desired browser
in line number : 17, like chrome, edge, firefox, internet, or opera.*/


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("chrome", "https://demo.nopcommerce.com");


    }

    @Test
    public void navigateToRegister() {
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();

        String expectedMessage = "Register";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        String actualMessage = message.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void registerPageSuccessfully() throws InterruptedException {
        navigateToRegister();

        Thread.sleep(1000);

        WebElement radioBtnMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
        radioBtnMale.click();

        Thread.sleep(1000);


        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("james");

        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("bond");

        Thread.sleep(1000);

        WebElement dateOfBirthDay = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]/option[11]"));
        dateOfBirthDay.click();

        Thread.sleep(1000);

        WebElement dateOfBirthMonth = driver.findElement(By.xpath("//option[contains(text(),'October')]"));
        dateOfBirthMonth.click();

        Thread.sleep(1000);

        WebElement dateOfBirthYear = driver.findElement(By.xpath("//option[contains(text(),'1950')]"));
        dateOfBirthYear.click();

        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys("arpan20_15thoct@yahoo.couk");

        Thread.sleep(1000);

        WebElement companyField = driver.findElement(By.xpath("//input[@id='Company']"));
        companyField.sendKeys("TCS");

        Thread.sleep(1000);

        WebElement newsletterCheckBox = driver.findElement(By.xpath("//input[@id='Newsletter']"));
        newsletterCheckBox.isSelected();

        Thread.sleep(1000);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
        passwordField.sendKeys("arpan123");

        Thread.sleep(1000);

        WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPasswordField.sendKeys("arpan123");

        Thread.sleep(1000);

        WebElement register = driver.findElement(By.xpath("//input[@id='register-button']"));
        register.click();

        Thread.sleep(1000);

        String expectedSuccessfulRegisterMessage = "Your registration completed";
        WebElement registerMessage = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualRegisterMessage = registerMessage.getText();

        Assert.assertEquals(expectedSuccessfulRegisterMessage, actualRegisterMessage);
    }
@After
    public void tearDown() {
        closeBrowser();
    }

}
