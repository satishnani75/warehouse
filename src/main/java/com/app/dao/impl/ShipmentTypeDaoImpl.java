package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
		
		// by using hal
		/*String hql=" select shipmentMode, count(shipmentMode) from com.app.model.ShipmentType group by shipmentMode ";
		
		
                  List<Object[]> list=		(List<Object[]>) ht.find(hql);*/
		
		
		DetachedCriteria hql =DetachedCriteria.forClass(ShipmentType.class)
				
				.setProjection(Projections.projectionList()
				
				.add(Projections.groupProperty("shipmentMode"))
				.add(Projections.count("shipmentMode"))
				);
		
	                         List<Object[]> list=	(List<Object[]>) ht.findByCriteria(hql);
		
		
		
		return list;
	}

	
	@Override
	public boolean isShipmentCodeExist(String shpmntCode) {

	    long count=0;
	    
	    
		/*String hql= " select count(shipmentCode) " + " from " + ShipmentType.class.getName() + " where shipmentCode=? ";
		 
		        List<Long> list =(List<Long>) ht.find(hql, shpmntCode);*/
	    
	    
	    
	    // by using detached criteria
	    
	    
	          DetachedCriteria hql = DetachedCriteria.forClass(ShipmentType.class)
	        		  
	        		  .setProjection(Projections.projectionList()
	        				  .add(Projections.count("shipmentCode"))
	        				  )
	        		  .add(Restrictions.eq("shipmentCode", shpmntCode));
	        		  
	        		  
	        		  
	        		  
	                              @SuppressWarnings("unchecked")
								List<Long> list		=  (List<Long>) ht.findByCriteria(hql);
		
		        if(list!=null && ! list.isEmpty() ) {
		        	
		               count=  list.get(0);
		        	
		        }
		        
		
		return count>0?true:false;
	}
	
}
