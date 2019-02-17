package com.app.service;

import java.util.List;

import com.app.model.WhuserType;



public interface IWhUserTypeService {

	
public Integer saveWhUserType(WhuserType wutobj );
	
	public void updateWhUserType(WhuserType wutobj);
	
	public void deleteWhUserType(Integer wutid) ;
	
	public WhuserType getWhUserTypeById(Integer wutid);
	
	
	public List<WhuserType> getAllWhUserTypes();
}
