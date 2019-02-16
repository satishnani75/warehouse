package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.idao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	
	@Transactional
	@Override
	public Integer saveOrderMethod(OrderMethod omobj) {
		
		return dao.saveOrderMethod(omobj);
	}

	@Transactional
	@Override
	public void updateOrderMethod(OrderMethod omobj) {

           dao.updateOrderMethod(omobj);
		
	}

	
	@Transactional
	@Override
	public void deleteOrderMethod(Integer omid) {
		dao.deleteOrderMethod(omid);
		
	}

	@Transactional(readOnly=true)
	@Override
	public OrderMethod getOrderMethodById(Integer omid) {
		
		return dao.getOrderMethodById(omid);
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderMethod> getAllOrdermethods() {
		
		return dao.getAllOrdermethods();
	}

	
	
	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getOrderModeTypeCount() {
		
		return dao.getOrderModeTypeCount();
	}
}
