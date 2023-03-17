package Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtil {

    public static WebDriver driver;

    public static void waitForElement(WebDriver driver, WebElement element, int s) {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(s));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForElementToBeClickable(WebDriver driver,WebElement element,int s) {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(s));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
  public static void keyboardEnter(){
      Actions act= new Actions(driver);
      act.sendKeys(Keys.ENTER).perform();
  }
}


