package com.selenium.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.GoogleSearchPageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class GoogleSearchPageTest {
    private static WebDriver webDriver = null;
    public static void main(String[] args)  {
        googleSearch();
    }
    @Test
    public static void googleSearch(){
        webDriver = new ChromeDriver();
        String searchText = "IT Companiesr";
        webDriver.get("https://www.google.com");

       GoogleSearchPageObject g1 = new GoogleSearchPageObject(webDriver);
       g1.searchBox(searchText);
       g1.searchButton();
        webDriver.close();
    }
}
