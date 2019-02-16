package com.app.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.idao.IOrderMethodDao;
import com.app.model.OrderMethod;


@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer saveOrderMethod(OrderMethod omobj) {
		
	        
		
		
		return (Integer)ht.save(omobj);
	}

	@Override
	public void updateOrderMethod(OrderMethod omobj) {
		ht.update(omobj);

	}

	@Override
	public void deleteOrderMethod(Integer omid) {
		
		
		ht.delete( new OrderMethod(omid));

	}

	@Override
	public OrderMethod getOrderMethodById(Integer omid) {
		
		
		
		return ht.get(OrderMethod.class, omid);
	}

	@Override
	public List<OrderMethod> getAllOrdermethods() {
		
		return ht.loadAll(OrderMethod.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Object[]> getOrderModeTypeCount() {
		
		String hql=" select orderMode , count(orderMode) from com.app.model.OrderMethod group by orderMode ";
		
		
		return (List<Object[]>) ht.find(hql);
	}
	
	
}
