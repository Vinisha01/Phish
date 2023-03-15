package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;

public class TestUtil {

    public static WebDriver driver;

    public static WebElement waitForElement(WebDriver driver,WebElement element,int s) {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(s));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public static void javaScript(WebDriver driver,WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
    }
    public static void roboClick() throws AWTException {
        Robot rob= new Robot();
        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    }

