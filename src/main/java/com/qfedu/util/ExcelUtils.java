package com.qfedu.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

public  static List<Map<String,Object>> readExcel(String fileName, InputStream inputStream) throws Exception{
    boolean ret = isXlS(fileName);
    Workbook workbook = null;

    if(ret==true){
        workbook = new HSSFWorkbook(inputStream);
    }else {
        workbook=new XSSFWorkbook(inputStream);
    }
    //读取第一个sheet
    Sheet sheet = workbook.getSheetAt(0);
    //读取第一行   第一行为 数据库字段属性
    Row titleRow = sheet.getRow(0);
    List<String> titleList = new ArrayList<>();
    //获取第一行单元格的数量
    short lastCellNum = titleRow.getLastCellNum();
    //将第一行字段属性读取出来 放入到list中
    for(int i=0; i < lastCellNum;i++){
        Cell cell = titleRow.getCell(i);
        // 设置单元格类型
        cell.setCellType(CellType.STRING);

        titleList.add(cell.getStringCellValue());
    }
    List<Map<String, Object>> list = new ArrayList<>();
    //获取总行数
    int lastRowNum = sheet.getLastRowNum();
    for(int i=1;i<=lastRowNum ; i++){
        Row row = sheet.getRow(i);
        Map<String ,Object> map = new HashMap<>();
        for(int j=0;j< lastCellNum;j++){
            Cell cell = row.getCell(j);
            if(cell==null){
                continue;
            }
            cell.setCellType(CellType.STRING);
            map.put(titleList.get(j),cell.getStringCellValue());
        }
        list.add(map);
    }
    workbook.close();
    return list;

}












    public static  boolean isXlS(String fileName){
        if(fileName.matches("^.+\\.(?i)(xls)$")){
            return true;
        }else if(fileName.matches("^.+\\.(?i)(xlsx)$")){
            return false;
        }else{
            throw  new RuntimeException("格式错误");
        }
    }
}
