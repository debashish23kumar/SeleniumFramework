package com.selenium.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int minRetryCount = 0;
    int maxRetryCount = 5;
    @Override
    public boolean retry(ITestResult result) {
        if(minRetryCount < maxRetryCount){
            minRetryCount++;
            return true;
        }
        return false;
    }
}
