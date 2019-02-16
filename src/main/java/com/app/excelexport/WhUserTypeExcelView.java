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
import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		   List<WhUserType> list= (List<WhUserType>)model.get("list");
		
		         Sheet sheet=   workbook.createSheet("whusertypedata");
		                    
		            showhead(sheet);
		            
		            showBody(sheet,list);
		            
		                           
		
		
	}

	private void showhead(Sheet sheet) {
		
		
Row row=sheet.createRow(0);
		
		row.createCell(0).setCellValue("uid");
		row.createCell(1).setCellValue("type");
		row.createCell(2).setCellValue("code");
		row.createCell(3).setCellValue("user for");
		
		row.createCell(4).setCellValue("email");
		
		row.createCell(5).setCellValue("contact");
		
		row.createCell(6).setCellValue("idtype");
		
		row.createCell(7).setCellValue("otherid");
		
		row.createCell(8).setCellValue("idno");
		
		
		
		
	}

	private void showBody(Sheet sheet, List<WhUserType> list) {
		
		

		int rowcout=1;
		
		for(WhUserType um:list) {
			
			Row row=		sheet.createRow(rowcout++);	
			
			
			row.createCell(0).setCellValue(um.getUserId());
			
			row.createCell(1).setCellValue(um.getUtype());
			
			row.createCell(2).setCellValue(um.getUcode());
			
			row.createCell(3).setCellValue(um.getUserfor());
			
			
			row.createCell(4).setCellValue(um.getEmail());
			
			row.createCell(5).setCellValue(um.getUcontact());
			
			row.createCell(6).setCellValue(um.getIdType());
			
			row.createCell(7).setCellValue(um.getOtherId());
			
			row.createCell(8).setCellValue(um.getIdnumber());
			
			
			
			
			
		
	}

}
}