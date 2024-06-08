package com.selenium.demo;

import com.selenium.listeners.RetryAnalyzer;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgRetryAnalyzerDemo {

    @Test
    public void test1(){
        System.out.println("first test");
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void test2(){
        System.out.println("second test");
        int i=1/0;
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void test3(){
        System.out.println("Third Test");
        Assert.assertTrue(0>1);
    }
}
