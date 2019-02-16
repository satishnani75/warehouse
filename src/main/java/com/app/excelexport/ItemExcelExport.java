package com.app.excelexport;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Item;

public class ItemExcelExport extends AbstractXlsxView {

	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		//to change file name after download
		
		response.setHeader("Content-Disposition", "attachment;filename=Itemlist.xlsx");
		
		//reading data from model
				List<Item> list=(List<Item>) model.get("list");
				//creating sheet
				Sheet sheet=workbook.createSheet("item list");
				//set Head-row-0
				setHead(sheet);
				//set Body-Row#1
				setBody(sheet,list);
				
			}

			private void setHead(Sheet sheet) {
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("code");
				row.createCell(2).setCellValue("WIDTH");
				row.createCell(3).setCellValue("LENGTH");
				row.createCell(4).setCellValue("HEIGHT");
				row.createCell(5).setCellValue("BASE-COST");
				
				row.createCell(6).setCellValue("BASE-CURNCY");
				row.createCell(7).setCellValue("DESC");
				
				row.createCell(8).setCellValue("uom");
				
				row.createCell(9).setCellValue("odr-mthd");
			}
			
			private void setBody(Sheet sheet, List<Item> list) {
				int rowNum=1;
				for(Item s:list) {
					Row row=sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(s.getId());
					row.createCell(1).setCellValue(s.getItemcode());
					row.createCell(2).setCellValue(s.getWidth());
					row.createCell(3).setCellValue(s.getLength());
					row.createCell(4).setCellValue(s.getHeight());
					row.createCell(5).setCellValue( s.getCost());
					row.createCell(6).setCellValue(s.getBaseCurrency());
					row.createCell(7).setCellValue(s.getDescrep());
					
					
					row.createCell(8).setCellValue(s.getUom().getUomModel());
					
					row.createCell(9).setCellValue(s.getOdm().getOrderCode());
					
					
				}
	}
	
	
}
