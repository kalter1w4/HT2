package PageObjects.GitPage;

import PageObjects.Base.BasePage;
import org.openqa.selenium.WebDriver;
import PageObjects.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GitPage extends BasePage {
    public GitPage(WebDriver driver) {
        super(driver);
    }
    private final By searchField = By.xpath("//*[@id=\"dashboard-repos-filter-left\"]");
    private final By FirstRepositoryItem = By.xpath("/html/body/div[1]/div[6]/div/aside/div/loading-context/div/div[1]/div/ul/li/div/div/a");
    public GitPage EnterSearchQuery(String query)
    {
        driver.findElement(searchField).sendKeys(query);
        return this;
    }
    public void GoToSearchedElement()
    {
        waitElementIsVisible(driver.findElement(FirstRepositoryItem)).click();
    }

}
