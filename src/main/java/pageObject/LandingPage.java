package pageObject;

import Utils.TestUtil;
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LandingPage extends Base {

    @FindBy(xpath = "//img[@alt='companyIcon']")
    private WebElement logo;

    @FindBy(xpath = "//input[@placeholder='Enter email']")
    private WebElement email;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement contiue;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    private WebElement loginButtn;


    public LandingPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    public boolean logoPresent(){
      boolean flag=  logo.isDisplayed();
      return flag;
    }

    public DashboardPage login() throws IOException {
        email.sendKeys((prop.getProperty("email")));
        TestUtil.waitForElement(driver,contiue,3);
       // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Continue']")));
        contiue.click();
        TestUtil.waitForElement(driver,password,3);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        password.sendKeys(prop.getProperty("password"));
        TestUtil.waitForElement(driver,loginButtn,3);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Log in']")));
        loginButtn.click();
        return new DashboardPage();

    }
}
