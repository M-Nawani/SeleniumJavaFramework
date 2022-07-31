package com.mystore.dataprovider;

import com.mystore.utilities.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class DataProviders {
        ExcelLibrary myExcel = new ExcelLibrary();

        @DataProvider(name = "getCredentials")
        public Object [][] getCredentials(){
            int rows = myExcel.getRowCount("Credentials");
            int columns = myExcel.getColumnCount("Credentials");
            Object [][] data = new Object[rows-1][columns];
            for(int i=0; i<rows-1; i++){
                for(int j=0; j<columns; j++){
                    data[i][j] = myExcel.getCellData("Credentials",j,i+2);
                }
            }
            return data;
        }
}
