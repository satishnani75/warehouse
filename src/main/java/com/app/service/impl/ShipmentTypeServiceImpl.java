package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.idao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;
	
	
	@Transactional
	public Integer saveShipmentType(ShipmentType st) {
		
		return dao.saveShipmentType(st);
	}

    @Transactional
	public void updateShipmentType(ShipmentType st) {
		
    	dao.updateShipmentType(st);

	}

	@Transactional
	public void deleteShipmentType(Integer sid) {
		dao.deleteShipmentType(sid);

	}

	@Transactional
	@Override
	public ShipmentType getShipmentTypeBYId(Integer sid) {
		
		return dao.getShipmentTypeBYId(sid);
	}

	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipments() {
		
		return dao.getAllShipments();
	}

	
	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getShipmentTypeByName() {
		
		return dao.getShipmentTypeByName();
	}
	
	
	@Override
	public boolean isShipmentCodeExist(String shpmntCode) {
		return dao.isShipmentCodeExist(shpmntCode);
	}
}
