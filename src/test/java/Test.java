import Utils.TestUtil;
import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import pageObject.BulkScanPage;
import pageObject.DashboardPage;
import pageObject.LandingPage;

import java.awt.*;
import java.io.IOException;

public class Test extends Base {

    LandingPage landingPage;
    DashboardPage dashboardPage;
    BulkScanPage bulkScanPage;
    public Test() throws IOException {
      super();
    }

    @BeforeMethod
    public void SetUp() throws IOException {
        initialization();
        landingPage= new LandingPage();
        dashboardPage= new DashboardPage();
        bulkScanPage = new BulkScanPage();
    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

    @org.testng.annotations.Test(priority = 1)
    public void verifyLogo(){
        Assert.assertTrue(landingPage.logoPresent());
    }
    @org.testng.annotations.Test(priority = 2)
    public void login() throws IOException {
        landingPage.login();
    }
    @org.testng.annotations.Test(priority = 3)
    public void goTOBulkScan() throws IOException {
     landingPage.login();
     dashboardPage.bulkScanPresent();
     dashboardPage.clickBulkScan();

    }
    @org.testng.annotations.Test(priority = 4)
    public void enterURLS() throws IOException, AWTException {
        goTOBulkScan();
     Assert.assertTrue(bulkScanPage.scanTextPresent());
     bulkScanPage.readExcel();
     bulkScanPage.clickListView();
    }
    @org.testng.annotations.Test(priority = 5)
    public void checkrows() throws IOException {

    }
}




