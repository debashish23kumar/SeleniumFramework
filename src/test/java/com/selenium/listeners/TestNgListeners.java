package com.selenium.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test  started :"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test  passed: "+result.getName());
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test  failed: "+result.getName());
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test  skipped: "+result.getName());
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
