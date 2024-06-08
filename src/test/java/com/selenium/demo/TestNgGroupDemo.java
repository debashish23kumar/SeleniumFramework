package com.selenium.demo;

import org.testng.annotations.Test;
@Test(groups = {"All tests"})
public class TestNgGroupDemo {

    @Test(groups = {"smoke"})
    public void Test1() {
        System.out.println("Test1 is running: ");
    }

    @Test(groups = {"sanity"})
    public void Test2() {
        System.out.println("Test2 is running: ");
    }

    @Test(groups = {"regression"})
    public void Test3() {
        System.out.println("Test3 is running: ");
    }

    @Test(groups = {"regression", "smoke", "sanity"})
    public void Test4() {
        System.out.println("Test3 is running: ");
    }
}

