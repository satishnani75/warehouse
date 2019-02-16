package com.app.excelexport;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		//to change file name after download
		
		response.setHeader("Content-Disposition", "attachment;filename=uomdata.xlsx");

		                    List<Uom> list =(List<Uom>)model.get("list");
		
		                   Sheet sheet =workbook.createSheet("uom-excelsheet");
		                    
		                   setHead(sheet);
		                   
		                   setBody(sheet,list);
		
		
	}

	

	private void setHead(Sheet sheet) {
		
		
		Row row=sheet.createRow(0);
		
		row.createCell(0).setCellValue("uid");
		row.createCell(1).setCellValue("type");
		row.createCell(2).setCellValue("model");
		row.createCell(3).setCellValue("desc");
		
		
		
		
	}
	
	
	
	
	private void setBody(Sheet sheet, List<Uom> list) {
	
		int rowcout=1;
		
		for(Uom um:list) {
			
			Row row=		sheet.createRow(rowcout++);	
			
			
			row.createCell(0).setCellValue(um.getUomId());
			
			row.createCell(1).setCellValue(um.getUomType());
			
			row.createCell(2).setCellValue(um.getUomModel());
			
			row.createCell(3).setCellValue(um.getDsc());
			
			
			
		}
		
        
		
                       
                           
	}

}
