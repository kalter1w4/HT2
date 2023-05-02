package PageObjects.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;

public class BasePage {
 protected WebDriver driver;
 public BasePage (WebDriver driver){

     this.driver = driver;
 }
 public void OpenPage(String url){

     driver.get(url);
 }
 public WebElement waitElementIsVisible (WebElement webElement){
 new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(webElement));
 return webElement;
 }
}
