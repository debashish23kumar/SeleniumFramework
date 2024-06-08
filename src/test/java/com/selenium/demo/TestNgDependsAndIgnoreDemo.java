package com.selenium.demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNgDependsAndIgnoreDemo {
    @Test(dependsOnMethods = {"depends1","depends2"})
    public void depends(){
        System.out.println("This is a depends method");
    }
    @Test
    public void depends1(){
        System.out.println("This is depends1 method");
    }
    @Test
    public void depends2(){
        System.out.println("This is depends2 method");
    }
    @Test
    public void ignore(){
        System.out.println("Ignore 1 Test is running");
    }

}
