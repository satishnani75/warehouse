package com.app.idao;

import java.util.List;

import com.app.model.Documents;

public interface IDocumentsDao {

	
	public Integer saveDoc(Documents dobj) ;
	
	public List<Object[]> getDocIdAndNames();
	
	public Documents getDocumentsById(Integer fid);
	
	
}
