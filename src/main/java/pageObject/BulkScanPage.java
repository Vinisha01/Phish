package pageObject;

import Utils.TestUtil;
import base.Base;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        PageFactory.initElements(driver, this);
    }

    public boolean scanTextPresent() {
        boolean flag = Scantext.isDisplayed();
        return flag;
    }


    public void clickListView() {
        ListView.click();
    }

    public void readExcel() throws IOException {
        FileInputStream f = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\SampleFramework\\MyProject\\practisePhish\\src\\test\\TestData\\urlData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(f);
        XSSFSheet sheet = wb.getSheet("Sheet1");
     //   Iterator row = sheet.iterator();
        int totalRows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < totalRows; i++) {
            XSSFRow row1 = sheet.getRow(i);
            String url = row1.getCell(0).getStringCellValue();
            TestUtil.waitForElementToBeClickable(driver, ScanURLTxt, 3);
            ScanURLTxt.sendKeys(url);
            TestUtil.waitForElement(driver, Submit, 3);
            TestUtil.keyboardEnter();
        }
        Submit.click();
    }

    public void listOfUrls() throws IOException, InterruptedException {
        FileInputStream f = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\SampleFramework\\MyProject\\practisePhish\\src\\test\\TestData\\urlData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(f);
        XSSFSheet sheet = wb.getSheet("Sheet1");
       // Iterator row = sheet.iterator();
        int totalRows = sheet.getPhysicalNumberOfRows();
//        for (int i = 0; i < totalRows; i++) {
//            XSSFRow row1 = sheet.getRow(i);
//            String url = row1.getCell(0).getStringCellValue();
            ArrayList <String> ColumnData = new ArrayList<>();
            for (int i = 1; i < totalRows; ++i) {
                Thread.sleep(100L);
                final Cell cell2Update2 = sheet.getRow(i).getCell(0);
                final String celldata2 = cell2Update2.toString();
                Thread.sleep(100L);
                ColumnData.add(celldata2);
            }
        for (final String s : ColumnData) {
            ColumnData.add(s);
        }
        System.out.println(ColumnData);
        }
    }

