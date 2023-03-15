package pageObject;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class DashboardPage extends Base {

    @FindBy(xpath = "//span[normalize-space()='Bulk Scan']")
    private WebElement BulkScan;



    public DashboardPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    public boolean bulkScanPresent(){
     boolean flag=   BulkScan.isDisplayed();
     return flag;
    }
    public BulkScanPage clickBulkScan() throws IOException {
        BulkScan.click();
        return new BulkScanPage();
    }
}
