package com.app.idao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {

	public Integer saveWhUserType(WhUserType wutobj );
	
	public void updateWhUserType(WhUserType wutobj);
	
	public void deleteWhUserType(Integer wutid) ;
	
	public WhUserType getWhUserTypeById(Integer wutid);
	
	
	public List<WhUserType> getAllWhUserTypes();
	
}
