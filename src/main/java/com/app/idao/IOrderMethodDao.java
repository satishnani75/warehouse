package com.app.idao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDao {

	public Integer saveOrderMethod(OrderMethod omobj);
	
	
	public void updateOrderMethod(OrderMethod omobj);
	
	
	public void deleteOrderMethod(Integer omid);
	
	
	public OrderMethod getOrderMethodById(Integer omid);
	
	
	public List<OrderMethod> getAllOrdermethods();
	
	
	public List<Object[]> getOrderModeTypeCount();
	
	
	
	
	
}
