package com.selenium.demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgParametersDemo {
    @Test
    @Parameters({"BrowserName"})
    public void Test1(String name){
        System.out.println("Browser Name is: " + name);

    }
}
