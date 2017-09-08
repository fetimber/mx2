package net.huimin.common.helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class FileHelper {
    
	 private static ArrayList<String> honorTemplateList = new ArrayList<String>(){
		{
			add(0,"职工姓名");
			add(1,"性别");
			add(2,"年龄");
			add(3,"身份证");
			add(4,"银行卡");
			add(5,"家庭地址");
			add(6,"职工身份");
			add(7,"联系电话");
			add(8,"获奖时间");
			add(9,"荣誉种类");
			add(10,"荣誉级别");
			add(11,"个人主要事迹");
			add(12,"集体主要事迹");
			add(13,"表彰文件签发单位标题文号");
			add(14,"奖章编号");	 			
		} 
	 };
	
	 private static ArrayList<String> workerPoorTemplateList = new ArrayList<String>(){
			{
				add(0,"职工姓名");
				add(1,"性别");
				add(2,"年龄");
				add(3,"身份证");
				add(4,"银行卡");
				add(5,"家庭地址");
				add(6,"职工身份");
				add(7,"联系电话");
				add(8,"家庭人数");
				add(9,"家庭收入");
				add(10,"困难标准");
				add(11,"致困原因");
				add(12,"说明");
			
			} 
		 };

		 public static WritableSheet convertResult2Sheet(WritableWorkbook workbook,String sheetName,List<Map<String,Object>> dbRes) throws Exception{
			 WritableSheet res = workbook.createSheet(sheetName, 0);
			 List<String> cols = new ArrayList<String>();
			 List<String> units = new ArrayList<String>();
			 Map<String,Integer> unitPos = new HashMap<String,Integer>();
			 cols.add("单位名称");
			 for(Map<String,Object> row : dbRes){
				 String unit_name = String.valueOf(row.get("unit_name"));
				 String honor_type = String.valueOf(row.get("honor_type"));
				 if(honor_type!= null &&!"null".equals(honor_type) && !cols.contains(honor_type)) cols.add(honor_type);
				 if(unit_name!= null &&!"null".equals(unit_name) && !units.contains(unit_name)) units.add(unit_name);
			 }
			 cols.add("合计");
			 
			 //生成空表
			 List<Map<String,String>> table = new ArrayList<Map<String,String>>();
			 int i = 0;
			 for(String unit_name : units){
				 Map<String,String> row = new HashMap<String,String>();
				 for(String honor_type : cols){
					 row.put(honor_type, "0");
				 }
				 row.put("单位名称", unit_name);
				 table.add(row);
				 unitPos.put(unit_name, i);
				 i++;
			 }
			 
			 //填充内容
			 for(Map<String,Object> row : dbRes){
				 String unit_name = String.valueOf(row.get("unit_name"));
				 String honor_type = String.valueOf(row.get("honor_type"));
				 String c = String.valueOf(row.get("c"));
				 Integer rowNum = unitPos.get(unit_name);
				 Map<String,String> tableRow = table.get(rowNum);
				 tableRow.put(honor_type, c);
			 }
			 //计算合计
			 
			 for(Map<String,String> row : table){
				 int total = 0;
				 for(String value : row.values()){
					 try{
						 int v = Integer.valueOf(value);
						 total+=v;
					 }catch(Exception e){
					 }
				 }
				 row.put("合计", String.valueOf(total));
			 }
			 
			 //生成文件
//			 WritableSheet sheet = workbook.createSheet(sheetName, 0);
			 i = 0;
			 for(String cell : cols){
				 res.addCell(new Label(i, 0, cell));
				 res.setColumnView(i, 30);
				 i++;
			 }
			 
			 
			 int j = 1;
			 for(Map<String,String> row : table){
				 i = 0;
				 for(String cell : cols){
					 res.addCell(new Label(i, j, row.get(cell)));
					 i++;
				 }
				 j++;
			 }
			 
			 return res;
		 }
	  public static List<String[]> parseXls4ReimburseData(File file,String fileType)
	    {
	    	 List<String[]> resList = new ArrayList<String[]>();
	         InputStream in = null;
	         try 
	         {
	        	 // 定义Excel
	             Workbook wookbook = null;
	             // 读取文件流
	             in = new FileInputStream(file);
	             // 转换POI流
	             POIFSFileSystem fs = new POIFSFileSystem(in);
	             // 转换问POIExcel
	             wookbook = new HSSFWorkbook(fs);
	             // 获取Excel中的第一个Sheet
	             Sheet sheet = wookbook.getSheetAt(0);
	             // 获取Sheet中的所有的行
	             int rows = sheet.getPhysicalNumberOfRows();
	             
	             int cellCount = 0;
	             // 是否跳过当前行标记值
	             Boolean flag = Boolean.TRUE;
	             Boolean check = Boolean.TRUE;
	             for (int i = 0; i < rows; i++) 
	             {
	                 Row row = sheet.getRow(i);
	                 if (row != null)
	                 {
	                     if (i == 0)
	                     {
	                    	 // 第一行为标题校验模板
	                    	 for (int cj = 0; cj < row.getPhysicalNumberOfCells(); cj++) 
		                     {
	                    		 Cell checkCell = row.getCell(cj);
	                    		 if("99".equals(fileType)){	 
	                    			 if(!honorTemplateList.get(cj)
	                    					 .equals(checkCell.getStringCellValue().trim())){
	                    				check = false;
	                    				break;
	                    			 }	 
		                    	 }else if("88".equals(fileType)){
		                    		 if(!workerPoorTemplateList.get(cj)
	                    					 .equals(checkCell.getStringCellValue().trim())){
	                    				check = false;
	                    				break;
	                    			 }			 
		                    	 }
		                     }
	                    	 
	                    	 if(check){
		                         cellCount = row.getPhysicalNumberOfCells();
		                         continue;
	                    	 }else {
	                    		 resList = null;
	                    		 break;    		 
	                    	 }           	
	                     }
	                     
	                     String[] obj = new String[cellCount];
	                     for (int j = 0; j < cellCount; j++) 
	                     {
	                         obj[j] = "";
	                         Cell cell = row.getCell(j);
	                         if (cell != null) 
	                         {
	                        	 // 当前Cell所属的行如果是标题行则跳过
	                        	 if(isMergedRow(sheet,i,j))
	                        	 {
	                        		 flag = Boolean.FALSE;
	                        		 break;
	                        	 }
	                        	 
	                             switch (cell.getCellType()) 
	                             {
	                                 case HSSFCell.CELL_TYPE_FORMULA:
	                                      break;
	                                 case HSSFCell.CELL_TYPE_NUMERIC:
	                                      if (HSSFDateUtil.isCellDateFormatted(cell))
	                                      {
	                                         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                                         obj[j] = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
	                                      } 
	                                      else 
	                                      {
	                                         obj[j] = String.valueOf(cell.getNumericCellValue());
	                                      }
	                                      break;
	                                 case HSSFCell.CELL_TYPE_STRING:
	                                     obj[j] = cell.getStringCellValue();
	                                     break;
	                                 default:
	                                     break;
	                             }

	                         }

	                         // 判断当前值是否为空
	                         if(j==0 || j==1)
	                         {
	                        	 // 判断当前单元格值是否为空
	                        	 if(Judge.isNullOrBlank(obj[j]))
	                        	 {
	                        		 // 判断当前单元格是否是合并单元格
	                        		 if(isMergedRegion(sheet,i,j))
	                        		 {
	                        			 // 如果是合并单元格取前一行中的值
	                        			 obj[j] = resList.get(resList.size()-1)[j];
	                        		 }
	                        		 
	                        	 }
	                         }
	                     }
	                     if(flag)
	                     {
	                    	 resList.add(obj);
	                     }
	                     
	                     flag = Boolean.TRUE;
	                 }
	             }

	         } 
	         catch (Exception e) 
	         {
	             throw new RuntimeException(e);
	         } 
	         finally 
	         {
	             if (null != in) 
	             {
	                 try
	                 {
	                     in.close();
	                 }
	                 catch (IOException e) 
	                 {
	                	 throw new RuntimeException(e);
	                 }
	             }
	         }
	             
	         return resList;
	    }
	  
	  
	  /**
	     * 去除结果集合中的无效数据
	     * 
	     * @param {List<String[]>} argList
	     * 
	     * @return {List<String[]>}
	     */
	    private static List<String[]> removeInvalidData(List<String[]> argList)
	    {
	    	Boolean flag = Boolean.TRUE;
	    	List<String[]> resList = new ArrayList<String[]>();
	    	
	    	for(int i=0;i<argList.size();i++)
	    	{
	    		// WBS描述
	    		String wbsDesribe = argList.get(i)[1];
	    		// 分解描述
	    		String resolveOfWbs = argList.get(i)[2];
	    		// 已执行金额
	    		String budget = argList.get(i)[3];
	    		
	    		if(Judge.isNullOrBlank(wbsDesribe) && Judge.isNullOrBlank(resolveOfWbs))
	    		{
	    			if("0".equals(budget))
	    			{
	    				flag = Boolean.FALSE;
	    			}
	    		}
	    		
	    		if(flag)
	    		{
	    			resList.add(argList.get(i));
	    		}
	    		
	    	}
	    	
	    	return resList;
	    }
	  
	  
	  /**
	     * 判断当前Cell所在的行是否是列合并
	     * 
	     * @param {org.apache.poi.ss.usermodel.Sheet} sheet
	     * 												当前Excel中的Sheet
	     * @param {int} rowIndex
	     * 						行索引
	     * @param {int} columnIndex
	     * 						列索引
	     * @return {Boolean}
	     */
	    private static Boolean isMergedRow(Sheet sheet,int rowIndex,int columnIndex)
	    {
	    	Boolean flag = Boolean.FALSE;
	    	// 获取合并单元格的数量
	    	int sheetMergeCount = sheet.getNumMergedRegions();
	    	
	    	for(int i=0;i<sheetMergeCount;i++)
	    	{
	    		CellRangeAddress range = sheet.getMergedRegion(i);
	    		int firstColumn = range.getFirstColumn();
	    		int lastColumn = range.getLastColumn();
	    		int firstRow = range.getFirstRow();
	    		int lastRow = range.getLastRow();
	    		if(rowIndex == firstRow && rowIndex == lastRow)
	    		{
	    			if(columnIndex >= firstColumn && columnIndex <= lastColumn)
	    			{
	    				flag = Boolean.TRUE;
	    			}
	    		}
	    		
	    	}
	    	
	    	return flag;
	    }
	    
	    /**
	     * 判断当前单元格是否是合并单元格
	     * 
	     * @param {org.apache.poi.ss.usermodel.Sheet} sheet
	     * 												当前Excel中的Sheet
	     * @param {int} rowIndex
	     * 						行索引
	     * @param {int} columnIndex
	     * 						列索引
	     * 
	     * @return {Boolean}
	     */
	    private static Boolean isMergedRegion(Sheet sheet,int rowIndex,int columnIndex)
	    {
	    	Boolean flag = Boolean.FALSE;
	    	// 获取合并单元格的数量
	    	int sheetMergeCount = sheet.getNumMergedRegions();
	    	
	    	for(int i=0;i<sheetMergeCount;i++)
	    	{
	    		CellRangeAddress range = sheet.getMergedRegion(i);
	    		int firstColumn = range.getFirstColumn();
	    		int lastColumn = range.getLastColumn();
	    		int firstRow = range.getFirstRow();
	    		int lastRow = range.getLastRow();
	    		if(rowIndex >= firstRow && rowIndex <= lastRow)
	    		{
	    			if(columnIndex >= firstColumn && columnIndex <= lastColumn)
	    			{
	    				flag = Boolean.TRUE;
	    			}
	    		}
	    		
	    	}
	    	
	    	return flag;
	    }

}
