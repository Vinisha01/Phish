package pageObject;

import Utils.TestUtil;
import base.Base;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class BulkScanPage extends Base {

    @FindBy(xpath = "//div[@class='page-title']")
    private static WebElement Scantext;

    @FindBy(xpath = "//textarea[@id='bulkScan.scanUrls']")
    private static WebElement ScanURLTxt;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private static WebElement Submit;

    @FindBy(xpath = "//img[@alt='display']")
    private WebElement ListView;


    public BulkScanPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    public boolean scanTextPresent(){
        boolean flag =Scantext.isDisplayed();
        return flag;
    }



    public void clickListView(){
        ListView.click();
    }
    public void readExcel() throws IOException {
        FileInputStream f = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\SampleFramework\\MyProject\\practisePhish\\src\\test\\TestData\\urlData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(f);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        Iterator row = sheet.iterator();
        int totalRows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < totalRows; i++) {
            XSSFRow row1 = sheet.getRow(i);
           String url = row1.getCell(0).getStringCellValue();
            TestUtil.waitForElementToBeClickable(driver, ScanURLTxt, 3);
            ScanURLTxt.click();
            ScanURLTxt.sendKeys(url);
            TestUtil.actionKeyboard(driver);
            TestUtil.waitForElement(driver, Submit, 3);
        }
        Submit.click();
    }}
