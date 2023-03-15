package pageObject;

import Utils.TestUtil;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class BulkScanPage extends Base {

    @FindBy(xpath = "//div[@class='page-title']")
    private WebElement Scantext;

    @FindBy(xpath = "//textarea[@id='bulkScan.scanUrls']")
    private WebElement ScanURLTxt;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement Submit;


    public BulkScanPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    public boolean scanTextPresent(){
        boolean flag =Scantext.isDisplayed();
        return flag;
    }
    public void enterURLData() throws AWTException {
        TestUtil.waitForElement(driver,Scantext,3);
        boolean flag=Scantext.isEnabled();
        System.out.println(flag);
        TestUtil.roboClick();
      //  TestUtil.javaScript(driver,Scantext);
        //Scantext.click();
        Scantext.sendKeys("www.google.com");
        TestUtil.waitForElement(driver,Submit,3);
        Submit.click();
    }
}
