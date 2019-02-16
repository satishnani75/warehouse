package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.idao.IDocumentsDao;
import com.app.model.Documents;

@Repository
public class DocumentsDaoImpl implements IDocumentsDao {

	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveDoc(Documents dobj) {
		
		
		
		return (Integer) ht.save(dobj);
	}

	@Override
	public List<Object[]> getDocIdAndNames() {
		
		String hql = "select fid,fname from com.app.model.Documents";
		
		                List<Object[]> data= (List<Object[]>) ht.find(hql);
		
		return data;
	}
	
	
	
	@Override
	public Documents getDocumentsById(Integer fid) {
		
		return ht.get(Documents.class, fid);
	}
}
