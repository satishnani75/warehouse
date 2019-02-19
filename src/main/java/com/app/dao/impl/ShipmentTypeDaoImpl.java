package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.idao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer saveShipmentType(ShipmentType st) {

		
		
		return (Integer)ht.save(st);
	}

	@Override
	public void updateShipmentType(ShipmentType st) {
		
		
		ht.update(st);

	}

	@Override
	public void deleteShipmentType(Integer sid) {
		
		
		ht.delete( new ShipmentType(sid));

	}

	@Override
	public ShipmentType getShipmentTypeBYId(Integer sid) {
		
		return ht.get(ShipmentType.class,sid);
	}

	@Override
	public List<ShipmentType> getAllShipments() {
		
		return ht.loadAll(ShipmentType.class);
	}

	
	@Override
	public List<Object[]> getShipmentTypeByName() {
		
		String hql=" select shipmentMode, count(shipmentMode) from com.app.model.ShipmentType group by shipmentMode ";
		
		/*DetachedCriteria hql2= DetachedCriteria.forClass(ShipmentType.class);*/		
		
		return (List<Object[]>) ht.find(hql);
	}

	
	@Override
	public boolean isShipmentCodeExist(String shpmntCode) {

	    long count=0;
		String hql= " select count(shipmentCode) " + " from " + ShipmentType.class.getName() + " where shipmentCode=? ";
		 
		        List<Long> list =(List<Long>) ht.find(hql, shpmntCode);
		
		        if(list!=null && ! list.isEmpty() ) {
		        	
		               count=  list.get(0);
		        	
		        }
		        
		
		return count>0?true:false;
	}
	
}
