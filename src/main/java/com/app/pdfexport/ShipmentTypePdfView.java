package com.app.pdfexport;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		response.setHeader("Content-Disposition", "attachment;filename=SHIPMENTS.pdf");
		
		           List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		
		                 Paragraph p = new Paragraph("hello form paragraph");
		                 
		                 document.add(p);
		                 
		                 PdfPTable table= new PdfPTable(6);
		                 
		                 table.addCell("id");
		                 table.addCell("mode");
		                 table.addCell("code");
		                 table.addCell("enable");
		                 table.addCell("grade");
		                 table.addCell("desc");
		                 
		                 for(ShipmentType s:list) {
		                	 
		                	 
		                	 
		                	 table.addCell(s.getId().toString());
		                	 
		                	 
		                	 table.addCell(s.getShipmentMode());
		                	 
		                	 table.addCell(s.getShipmentCode());
		                	 
		                	 
		                	 table.addCell(s.getEnableShipment());
		                	 
		                	 
		                	 table.addCell(s.getShipmentGrade());
		                	 
		                	 table.addCell(s.getShipdesc());
		                 }
		                	 
		                	 document.add(table);
		                	 
		                 
		                	 document.add(new Paragraph(new Date().toString()));
		                	 
		               
		                 
		                 
		
		
	}

}
