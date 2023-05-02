import Common.DriverInitialize;
import PageObjects.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AllTests {

    @Test @Parameters({"URL","GitLogin","GitPass"})
    public void EnterToLoginPage(String url,String username,String password)
    {
         WebDriver driver = DriverInitialize.GetDriver(DriverInitialize.Browser.EDGE);
         BasePage basePage = new BasePage(driver);
         basePage.OpenPage(url);
    }
}
