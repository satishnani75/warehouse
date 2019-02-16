package com.app.idao;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeDao {

	
	public Integer saveShipmentType(ShipmentType st) ;
	
	public void updateShipmentType(ShipmentType st);
	
	
	public void deleteShipmentType(Integer sid);
	
	
	public  ShipmentType getShipmentTypeBYId(Integer sid);
	
	
	public  List<ShipmentType> getAllShipments();
	
	public List<Object[]> getShipmentTypeByName();
	
	public boolean isShipmentCodeExist(String shpmntCode);
	
	
}
