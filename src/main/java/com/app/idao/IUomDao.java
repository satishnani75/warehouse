package com.app.idao;

import java.util.List;
import java.util.Map;

import com.app.model.Uom;

public interface IUomDao {

     public Integer saveUom(Uom uobj);
     
     
	public void updateUom(Uom uobj);
	
	
	public void deleteUom(Integer uid);
	
	
	public Uom getUomById(Integer uid);
	
	
	public List<Uom> getAllUoms();
	
	
	public boolean isUomModelExist(String uomModel);
	
	
	public Map<Integer,String> getUomIdandName();
	
	
	
}
