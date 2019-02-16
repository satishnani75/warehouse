package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.idao.IDocumentsDao;
import com.app.model.Documents;
import com.app.service.IDocumetsService;

@Service
public class DocumetnsServiceImpl implements IDocumetsService {

	@Autowired
	private IDocumentsDao dao;
	
	@Override
	@Transactional
	public Integer saveDoc(Documents dobj) {
		
		
		return dao.saveDoc(dobj);
	}

	@Override
	@Transactional
	public List<Object[]> getDocIdAndNames() {
		
		
		
		
		return dao.getDocIdAndNames();
	}
	
	
	@Transactional
	public Documents getDocumentsById(Integer fid) {
		
		return dao.getDocumentsById(fid);
	}
}
