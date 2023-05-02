package PageObjects.LoginPage;

import PageObjects.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private final By loginField = By.xpath("//*[@id=\"login_field\"]");
    private final By passwordField = By.xpath("//*[@id=\"password\"]");
    private final By signInButton = By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[12]");
    public LoginPage EnterCredentials(String username,String password)
    {
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage SignIn()
    {
        driver.findElement(signInButton).click();
        return this;
    }
}
