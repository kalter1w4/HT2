package Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

import java.time.Duration;

public class DriverInitialize {
   public static WebDriver GetDriver(Browser browser)
   {
       WebDriver driver = null;
       switch (browser) {
           case EDGE -> {
               System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/msedgedriver.exe");
               EdgeOptions options = new EdgeOptions();
               options.addArguments("--remote-allow-origins=*");
               driver = new EdgeDriver(options);
               break;
           }
           case CHROME -> {
               System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
               ChromeOptions options = new ChromeOptions();
               options.addArguments("--remote-allow-origins=*");
               driver = new ChromeDriver(options);
               break;
           }
           default -> Assert.fail("Incorect browser type" + browser);
       }

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
       driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));
       driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
       return driver;
   }
    public enum Browser
    {
        CHROME,EDGE
    }
}
