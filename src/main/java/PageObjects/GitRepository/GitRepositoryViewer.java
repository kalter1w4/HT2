package PageObjects.GitRepository;

import PageObjects.Base.BasePage;
import org.openqa.selenium.*;
import PageObjects.Base.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GitRepositoryViewer extends BasePage{
    public GitRepositoryViewer(WebDriver driver) {
        super(driver);
    }
    private By rawedText = By.xpath("/html/body/pre");
    private By repositorySearchField = By.xpath("//*[@id=\"repos-file-tree\"]/div[2]/span/input");
    private By goToFile = By.xpath("//*[@id=\"file-result-0\"]/div/div[2]");
    private  By BranchSwitherButton = By.xpath("//*[@id=\"branch-select-menu\"]/summary");
    private By rawButton = By.xpath("//*[@id=\"repos-sticky-header\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/a/span/span");
    private By repositoryFolder = By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div/div[2]/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/span/a");
    public void GoToRepositoryFolder()
    {
        driver.findElement(repositoryFolder).click();
    }
    public void EnterSearchField(String query)
    {
        waitElementIsVisible(driver.findElement(repositorySearchField)).sendKeys(query);
        waitElementIsVisible(driver.findElement(goToFile)).click();
    }
    public void ShowFileAsRaw()
    {
        waitElementIsVisible(driver.findElement(rawButton)).click();
    }
    public String GetRawedText()
    {
       return waitElementIsVisible(driver.findElement(rawedText)).getText();
    }
    public void SwitchBrachTo(String text)
    {
        waitElementIsVisible(driver.findElement(BranchSwitherButton)).click();
        waitElementIsVisible(driver.findElement(By.xpath("//*[text()='"+text+"']"))).click();
    }
}
