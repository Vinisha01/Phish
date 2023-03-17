package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
   public static WebDriver driver;
    public static Properties prop;

    public Base() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\SampleFramework\\MyProject\\CheckP\\src\\main\\resources\\config.properties");
        prop = new Properties();
        prop.load(fis);
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(co);
        }
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(prop.getProperty("url"));

    }
}
