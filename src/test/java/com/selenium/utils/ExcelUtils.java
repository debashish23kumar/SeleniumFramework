package com.selenium.utils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;


public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String path, String sheetName) {
        try {
            workbook = new XSSFWorkbook(path);
            sheet = workbook.getSheet(sheetName);
            workbook.close();
        } catch (Exception e) {
            System.out.println("Error Message Caught: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        int rowCount =0;
        try {
             rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("Total row count in excel: " + rowCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return rowCount;
    }

    public int getColCount() {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("Total col count in excel: " + colCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return colCount;
    }

    public String getStringCellData(int rowNum, int colNum){
        String cellData = null;
        try{
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            System.out.println("Dedicated String Cell Value: "+ cellData);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return cellData;

    }

    public  double getNumericCellData(int rowNum, int cellNum){
        double cellData = 0;
        try {
            cellData = sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
            System.out.println("Dedicated Numeric cell value: " + cellData);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return cellData;
    }
}
