package com.selenium.config;

import com.selenium.tests.DataProviderExcel;
import com.selenium.tests.ExntentWithTestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();


    public static void main(String[] args) {
            getProperty();
            setProperty();
            getProperty();
    }

    public static void getProperty() {
        try {
            InputStream input = new FileInputStream("src/test/java/com/selenium/config/config.properties");
            prop.load(input);
            String browName = prop.getProperty("browser");
            System.out.println("Browser name in config file: " + browName);
            ExntentWithTestNG.browserName = browName;
            DataProviderExcel.browserName = browName;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }

    public static void setProperty() {
        try {
            OutputStream output = new FileOutputStream("src/test/java/com/selenium/config/config.properties");
            prop.setProperty("browser", "safari");
            prop.store(output, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}
