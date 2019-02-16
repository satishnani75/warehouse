package com.app.excelexport;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.User;

public class UserExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setHeader("Content-Disposition", "attachment;filename=shipmenttypedata.xlsx");
		
		           List<User> list=(List<User>) model.get("list");
		
		       Sheet sheet  = workbook.createSheet("userdatasheet");
		       
		       
		       showHead(sheet);
		      
		       showBody(sheet ,list);
		       
		       
	}

	private void showHead(Sheet sheet) {
		
		
           Row row=	sheet.createRow(0);
		
           
           row.createCell(0).setCellValue("id");
		
           
           row.createCell(1).setCellValue("name");
           
           row.createCell(2).setCellValue("email");
           
           row.createCell(3).setCellValue("pwd");
           row.createCell(4).setCellValue("mobileno");
           row.createCell(5).setCellValue("roles");
           
           
           
	}

	private void showBody(Sheet sheet, List<User> list) {
		
		int rowcount=1;
		
		for(User u:list) {
			
			
		
		Row row=sheet.createRow(rowcount++);
		
		row.createCell(0).setCellValue(u.getUid());
		
		row.createCell(1).setCellValue(u.getUname());
		
		row.createCell(2).setCellValue(u.getEmail());
		
		row.createCell(3).setCellValue(u.getPwd());
		
		row.createCell(4).setCellValue(u.getMno());
		
		row.createCell(5).setCellValue(u.getRoles().toString());
		
		
		
		
	}
	}
}
