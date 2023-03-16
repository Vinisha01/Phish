package pageObject;

import Utils.TestUtil;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

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
        contiue.click();
        TestUtil.waitForElement(driver,password,3);
        password.sendKeys(prop.getProperty("password"));
        TestUtil.waitForElement(driver,loginButtn,3);
        loginButtn.click();
        return new DashboardPage();

    }
}
