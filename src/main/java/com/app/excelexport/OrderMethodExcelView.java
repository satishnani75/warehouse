package com.app.excelexport;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		
		response.setHeader("Content-Disposition", "attachment;filename=ORDER-METHOD-DATA.xlsx");
		
		              List<OrderMethod>  list  =   (List<OrderMethod>)   model.get("list");
		              
		              
		             Sheet sheet= workbook.createSheet("ordermethod-data");
		            
		             showHead(sheet);
		             
		             showBody(sheet,list);
		
	}


	private void showHead(Sheet sheet) {
		
		
		
		Row row=sheet.createRow(0);
		
		
		row.createCell(0).setCellValue("oid");
		
		row.createCell(1).setCellValue("mode");
		
		row.createCell(2).setCellValue("code");
		
		row.createCell(3).setCellValue("type");
		
		row.createCell(4).setCellValue("odsc");
		
		row.createCell(5).setCellValue("accept");
		
	}
	

	private void showBody(Sheet sheet, List<OrderMethod> list) {
		
		
		int rowcount=1;
		
		for(OrderMethod om:list) {
			
			Row row=sheet.createRow(rowcount++);
			
			row.createCell(0).setCellValue(om.getOid());
			
			
			row.createCell(1).setCellValue(om.getorderMode());
			
			row.createCell(2).setCellValue(om.getOrderCode());
			
			row.createCell(3).setCellValue(om.getExeType());
			
			row.createCell(4).setCellValue(om.getOrderDesc());
			
			row.createCell(5).setCellValue(om.getOrderAccept().toString());
			
			
		
	}
	}
}
