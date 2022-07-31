package com.mystore.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import java.util.Calendar;

import java.io.FileInputStream;

public class ExcelLibrary {

    public String filePath = System.getProperty("user.dir")+ "/src/main/resources/TestData/TestData.xlsx";
    public FileInputStream inputStream;
    public XSSFWorkbook xssfWorkbook;
    public XSSFSheet xssfSheet;
    public XSSFRow xssfRow;
    public XSSFCell cell;

    public  ExcelLibrary(){
        this.filePath = filePath;
        try{
            inputStream = new FileInputStream(filePath);
            xssfWorkbook = new XSSFWorkbook(inputStream);
            xssfSheet = xssfWorkbook.getSheetAt(0);
            inputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ExcelLibrary(String filePath){
        this.filePath = filePath;
        try{
            inputStream = new FileInputStream(filePath);
            xssfWorkbook = new XSSFWorkbook(inputStream);
            xssfSheet = xssfWorkbook.getSheetAt(0);
            inputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public int getRowCount(String sheetName){
        int index = xssfWorkbook.getSheetIndex(sheetName);
        if (index == -1) return 0;
        else{
            xssfSheet = xssfWorkbook.getSheetAt(index);
            return xssfSheet.getLastRowNum() + 1;
        }
    }

    public boolean isSheetExist(String sheetName){
        int index = xssfWorkbook.getSheetIndex(sheetName);
        if(index==-1){
            index=xssfWorkbook.getSheetIndex(sheetName.toUpperCase());
            if(index==-1)
                return false;
            else
                return true;
        }
        else
            return true;
    }


    public int getColumnCount(String sheetName){
        if(!isSheetExist(sheetName)) return -1;
        else{
            xssfSheet = xssfWorkbook.getSheet(sheetName);
            xssfRow = xssfSheet.getRow(0);

            if (xssfRow == null) return -1;
            return xssfRow.getLastCellNum();
        }
    }
    public String getCellData(String sheetName,int colNum,int rowNum){
        try{
            if(rowNum <=0)
                return "";

            int index = xssfWorkbook.getSheetIndex(sheetName);

            if(index==-1)
                return "";


            xssfSheet = xssfWorkbook.getSheetAt(index);
            xssfRow = xssfSheet.getRow(rowNum-1);
            if(xssfRow==null)
                return "";
            cell = xssfRow.getCell(colNum);
            if(cell==null)
                return "";

            if(cell.getCellType().name().equals("STRING"))
                return cell.getStringCellValue();
            else if(cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA") ){

                String cellText  = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // format in form of M/D/YY
                    double d = cell.getNumericCellValue();

                    Calendar cal =Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText =
                            (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.MONTH)+1 + "/" +
                            cal.get(Calendar.DAY_OF_MONTH) + "/" +
                            cellText;

                    // System.out.println(cellText);

                }

                return cellText;
            }else if(cell.getCellType().name().equals("BLANK"))
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch(Exception e){

            e.printStackTrace();
            return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
        }
    }


}
