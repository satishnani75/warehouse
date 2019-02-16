package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Documents;
import com.app.service.IDocumetsService;

@Controller
@RequestMapping("/doc")
public class DocumentsController {

	@Autowired
	private IDocumetsService service;

	@RequestMapping("/show")
	public String showDoc(ModelMap map) {
		// loadinga all uploaded data
		List<Object[]> list = service.getDocIdAndNames();
		map.addAttribute("list", list);

		return "Documents";
	}

	// on click upload
	@RequestMapping(value ="/upload", method = RequestMethod.POST)
	public String uploadDoc(@RequestParam("fileObj") CommonsMultipartFile file, ModelMap map) {
		if (file != null) { // convert CMF data to Model class obj
			Documents doc = new Documents();
			// doc.setFileId(fileId); auto generated
			doc.setFname(file.getOriginalFilename());
			doc.setFdata(file.getBytes());
			int id = service.saveDoc(doc);

			map.addAttribute("message", "Saved with Id:" + id);
		}
		// loadinga all uploaded data after upload
		List<Object[]> list = service.getDocIdAndNames();
		map.addAttribute("list", list);

		return "Documents";
	}

	// downloading documents
	@RequestMapping("/download")
	public void downlaodDoc(@RequestParam int fid,HttpServletResponse res) {
		
		// getting file id to download
		Documents doc =service.getDocumentsById(fid);
		
		
		//add headder
		res.addHeader("Content-Disposition", "attachment;filename="+doc.getFname());;
		
		//add body
		
		
		try {
			FileCopyUtils.copy(doc.getFdata(), res.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
