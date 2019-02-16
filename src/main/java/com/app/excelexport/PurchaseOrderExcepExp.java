package com.app.excelexport;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.PurchaseOrder;



public class PurchaseOrderExcepExp extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		             response.setHeader("Content-Disposition","attachment;filename=purchaseOrder-DATA.xlsx" );
		              List<PurchaseOrder> list =   (List<PurchaseOrder>) model.get("list");
		                             
		
		               Sheet sheet =workbook.createSheet("Purchase Order data");
		
		
		               head(sheet);
		               body(sheet,list);
		            
	}

	

	private void head(Sheet sheet) {

		
		Row row =sheet.createRow(0);
		
				row.createCell(1).setCellValue("id");
		
		row.createCell(2).setCellValue("code");
		
		row.createCell(3).setCellValue("shipment mode");
		
		row.createCell(4).setCellValue("vendor");
		
		
		row.createCell(5).setCellValue("ref no");
		
		row.createCell(6).setCellValue("qc");
		
         row.createCell(7).setCellValue("odrstatus");
		
		row.createCell(8).setCellValue("orderdesc");
	
		
		
	}
	
	
	private void body(Sheet sheet, List<PurchaseOrder> list) {
	
		
		int rid= 0;
		
		for(PurchaseOrder p :list) {
			
			Row row=sheet.createRow(rid++);
			
			row.createCell(rid).setCellValue(p.getOid());
			
			
			
			row.createCell(rid).setCellValue(p.getOrderCode());
			
			row.createCell(rid).setCellValue(p.getRefno());
			
			row.createCell(rid).setCellValue(p.getQc());
			row.createCell(rid).setCellValue(p.getOrderstatus());
			
			
			row.createCell(rid).setCellValue(p.getOrderdesc());
			
			row.createCell(rid).setCellValue(p.getShip().getShipmentCode());
			
			row.createCell(rid).setCellValue(p.getVendor().getUcode());
		}
		
		
		
		
		
	}

}
