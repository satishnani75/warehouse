package com.app.service;

import java.util.List;

import com.app.model.Documents;

public interface IDocumetsService {

	
	public Integer saveDoc(Documents dobj) ;
	
	public List<Object[]> getDocIdAndNames();
	
	public Documents getDocumentsById(Integer fid);
}
