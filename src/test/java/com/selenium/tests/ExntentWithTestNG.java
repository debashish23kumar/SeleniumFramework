package com.selenium.tests;

import com.aventstack.extentreports.*;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.config.PropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Stack;
//@Listeners(com.selenium.listeners.TestNgListeners.class)
public class ExntentWithTestNG {
   public static String browserName = null;
     Logger logger =  LogManager.getLogger(ExntentWithTestNG.class);
    private static WebDriver driver;
    ExtentSparkReporter sparkReporter;
    ExtentReports extent;
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
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
    }

        @Test()
        public void test1() throws InterruptedException {
        logger.info("This Test will validate the google search page and  text to search ");
        ExtentTest test1 = extent.createTest("Google search","Test will validate the google search page");
        test1.log(Status.INFO,"Go to Google url");
        driver.get("https://google.com");
        test1.pass("Navigated to google site");
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium java");
        test1.pass("Required text is entered");
        driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        test1.pass("Enter is pressed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test1.addScreenCaptureFromPath("screenshot.png");
        logger.info("Test1 is completed");
    }

    @Test
    public void test2() throws InterruptedException {
        ExtentTest test1 = extent.createTest("Google search", "Test will validate the google search page");
        test1.log(Status.INFO, "Go to Google url");
        driver.get("https://swaglabs.in");
        test1.pass("Navigated to swaglabs site");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@class='elementor-item menu-link'])[3]")).click();
        test1.pass("Blogs tab is clicked");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='elementor-post__thumbnail__link']")).click();
        Thread.sleep(2000);
        test1.pass("Enter is pressed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test1.addScreenCaptureFromPath("screenshot.png");
    }

    @AfterTest
    public void teardownTest(){
        driver.close();
        driver.quit();
        System.out.println("Test Completed Successfully");
        logger.error("Error occured");
    }
    @AfterSuite
    public void teardownSuite(){
        extent.flush();
    }
}
