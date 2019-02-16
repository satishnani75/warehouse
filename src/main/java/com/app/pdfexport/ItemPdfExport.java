package com.app.pdfexport;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfExport extends AbstractPdfView {

	
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		response.setHeader("Content-Disposition", "attachment;filename=ITEMLIST.pdf");
		
		           List<Item> list=(List<Item>) model.get("list");
		
		                 Paragraph p = new Paragraph("hello form paragraph");
		                 
		                 document.add(p);
		                 
		                 PdfPTable table= new PdfPTable(6);
		                 
		                 table.addCell("id");
		                 table.addCell("code");
		                 table.addCell("width");
		                 table.addCell("lendht");
		                 table.addCell("hight");
		                 table.addCell("cost");
		                 table.addCell("currency");
		                 table.addCell("desc");
		                 table.addCell("orr-mthd");
		                 
		                 table.addCell("uom");
		                 for(Item s:list) {
		                	 
		                	 table.addCell(s.getId().toString());
		                	 
		                	 
		                	 table.addCell(s.getItemcode());
		                	 
		                	 table.addCell(String.valueOf(s.getWidth()));
		                	 table.addCell(String.valueOf(s.getLength()));
		                	 table.addCell(String.valueOf(s.getHeight()));
		                	 table.addCell(String.valueOf(s.getCost()));
		                	 
		                	 table.addCell(s.getBaseCurrency());
		                	table.addCell(s.getDescrep());
		                	 
		                	table.addCell(s.getUom().getUomModel());
		                	 
		                	table.addCell(s.getOdm().getOrderCode());
		                	
		                	 
		                	 
		                	 
		                 }
		                	 
		                	 document.add(table);
		                	 
		                 
		                	 document.add(new Paragraph(new Date().toString()));
		                	 
		               
		                 
		                 
		
		
	}

}
