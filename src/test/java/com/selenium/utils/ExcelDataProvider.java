package com.selenium.utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
    static String filePath = "excelFiles/data.xlsx";
    static String sheet = "data";

    @DataProvider(name = "loginData")
    public static Object[][]  getTestData(){
        Object[][] data = setTestdata(filePath, sheet);
        return data;
    }

    public static Object[][] setTestdata(String path, String sheetName) {
        ExcelUtils utils = new ExcelUtils(path, sheetName);
        int row = utils.getRowCount();
        int col = utils.getColCount();

        System.out.println("RowCount: "+ row +" "+"ColumnCount: "+col );

        Object[][] data = new Object[row - 1][col];

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                String cellData = utils.getStringCellData(i, j);
                data[i - 1][j] = cellData;
            }
        }
        return data;
    }
}
