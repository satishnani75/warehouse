package com.app.idao;

import java.util.List;


import com.app.model.WhuserType;

public interface IWhUserTypeDao {

	public Integer saveWhUserType(WhuserType wutobj );
	
	public void updateWhUserType(WhuserType wutobj);
	
	public void deleteWhUserType(Integer wutid) ;
	
	public WhuserType getWhUserTypeById(Integer wutid);
	
	
	public List<WhuserType> getAllWhUserTypes();
	
}
