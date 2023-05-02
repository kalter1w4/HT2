package BaseTest;

import Common.DriverInitialize;
import Common.XmlDeserializer;
import PageObjects.Base.BasePage;
import PageObjects.GitPage.GitPage;
import PageObjects.GitRepository.GitRepositoryViewer;
import PageObjects.LoginPage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    protected WebDriver driver = DriverInitialize.GetDriver(DriverInitialize.Browser.EDGE);
    protected BasePage basePage = new BasePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected GitPage gitPage = new GitPage(driver);
    protected GitRepositoryViewer gitRepositoryViewer = new GitRepositoryViewer(driver);
    protected XmlDeserializer xmlDeserializer = new XmlDeserializer();

@AfterSuite(alwaysRun=true)
        public void close()
{
    driver.quit();
}

}
