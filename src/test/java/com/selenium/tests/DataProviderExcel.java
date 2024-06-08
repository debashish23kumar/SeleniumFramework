package com.selenium.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.config.PropertiesFile;
import com.selenium.utils.ExcelDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class DataProviderExcel {
    WebDriver driver;
    WebElement element;
    static final Logger logger = LogManager.getLogger(DataProviderExcel.class);
    ExtentSparkReporter sparkReporter;
    ExtentReports extent;
    public static  String browserName = null;

    @BeforeSuite
    public void setup(){
        sparkReporter = new ExtentSparkReporter("target/TestNGReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        PropertiesFile.getProperty();

    }
    @BeforeTest
    public void setupTest() throws NullPointerException {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else System.out.println("Invalid Browser Property Fetched");
    }


    @Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
    public void userLoginTest(String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(username+ " | " +password);
        ExtentTest test1 = extent.createTest("OrangeHrmLoginTest","Test will validate the login process");
        test1.log(Status.INFO,"Go to OrangeHrmLive Page");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        test1.log(Status.INFO,"Username entered in the field");
        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys(username);
        logger.info("Username is entered in the login page");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("amcd")));
        System.out.println(element1);
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        Thread.sleep(4000);
    }

    @AfterTest
    public void teardownTest() {
        driver.close();
        driver.quit();
        logger.info("Test Completed Successfully");
    }

    @AfterSuite
    public void teardownSuite(){
        extent.flush();
    }
}
