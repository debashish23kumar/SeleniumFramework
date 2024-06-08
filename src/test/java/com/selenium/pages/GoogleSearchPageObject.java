package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchPageObject {
    WebDriver element = null;
    By search_box = By.id("APjFqb");
    By search_button = By.xpath("(//input[@name='btnK'])[2]");

    public GoogleSearchPageObject(WebDriver element){
        this.element = element;
    }

    public void searchBox(String SearchText){
       element.findElement(search_box).sendKeys(SearchText);
    }

    public  void searchButton(){
        element.findElement(search_button).sendKeys(Keys.RETURN);
    }
}
